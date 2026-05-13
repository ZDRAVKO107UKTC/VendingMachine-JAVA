package com.vendingmachine.dispenser;

import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.inventory.ISlot;
import com.vendingmachine.model.DispensingResult;
import com.vendingmachine.model.Money;
import com.vendingmachine.payment.IPaymentProcessor;

import java.util.Optional;

public class StandardDispenser implements IDispenser {

    @Override
    public DispensingResult dispense(String slotId, IInventory inventory, IPaymentProcessor payment) {
        Optional<ISlot> slotOpt = inventory.findSlot(slotId);
        if (!slotOpt.isPresent())       return DispensingResult.invalidSlot(slotId);

        ISlot slot  = slotOpt.get();
        Money price = slot.getProduct().getPrice();

        if (!slot.isAvailable())                    return DispensingResult.outOfStock(slot.getProduct().getName());
        if (!payment.getBalance().isAtLeast(price)) return DispensingResult.insufficientFunds(price.subtract(payment.getBalance()));

        slot.dispense();
        payment.deduct(price);
        Money change = payment.returnBalance();
        return DispensingResult.success(slot.getProduct(), change);
    }
}
