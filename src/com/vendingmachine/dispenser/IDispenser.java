package com.vendingmachine.dispenser;

import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.model.DispensingResult;
import com.vendingmachine.payment.IPaymentProcessor;

public interface IDispenser {
    DispensingResult dispense(String slotId, IInventory inventory, IPaymentProcessor payment);
}
