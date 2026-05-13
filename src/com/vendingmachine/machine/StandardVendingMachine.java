package com.vendingmachine.machine;

import com.vendingmachine.dispenser.IDispenser;
import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.payment.IPaymentProcessor;
import com.vendingmachine.revenue.IRevenueTracker;

public class StandardVendingMachine extends AbstractVendingMachine {

    public StandardVendingMachine(IInventory inventory, IPaymentProcessor payment,
                                   IDispenser dispenser, IRevenueTracker revenue) {
        super(inventory, payment, dispenser, revenue);
    }
}
