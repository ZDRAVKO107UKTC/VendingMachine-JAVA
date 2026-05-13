package com.vendingmachine.machine;

import com.vendingmachine.dispenser.IDispenser;
import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.model.DispensingResult;
import com.vendingmachine.model.Money;
import com.vendingmachine.payment.IPaymentProcessor;
import com.vendingmachine.revenue.IRevenueTracker;

public abstract class AbstractVendingMachine implements IVendingMachineController {
    protected final IInventory       inventory;
    protected final IPaymentProcessor payment;
    protected final IDispenser        dispenser;
    protected final IRevenueTracker   revenue;

    protected AbstractVendingMachine(IInventory inventory, IPaymentProcessor payment,
                                      IDispenser dispenser, IRevenueTracker revenue) {
        this.inventory = inventory;
        this.payment   = payment;
        this.dispenser = dispenser;
        this.revenue   = revenue;
    }

    @Override
    public void insertMoney(Money amount) { payment.insert(amount); }

    @Override
    public DispensingResult selectProduct(String slotId) {
        DispensingResult result = dispenser.dispense(slotId, inventory, payment);
        if (result.isSuccess()) onSaleCompleted(result);
        return result;
    }

    @Override public Money      returnChange()    { return payment.returnBalance(); }
    @Override public Money      getBalance()      { return payment.getBalance(); }
    @Override public Money      getTotalRevenue() { return revenue.getTotal(); }
    @Override public IInventory getInventory()    { return inventory; }

    @Override
    public void restock(String slotId, int amount) {
        inventory.findSlot(slotId).orElseThrow(
            () -> new IllegalArgumentException("Slot not found: " + slotId)
        ).restock(amount);
    }

    /** Template method — subclasses can extend post-sale behaviour. */
    protected void onSaleCompleted(DispensingResult result) {
        revenue.record(result.getProduct().getPrice());
    }
}
