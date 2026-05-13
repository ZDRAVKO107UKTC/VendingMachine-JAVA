package com.vendingmachine.machine;

import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.model.DispensingResult;
import com.vendingmachine.model.Money;

public interface IVendingMachineController {
    void             insertMoney(Money amount);
    DispensingResult selectProduct(String slotId);
    Money            returnChange();
    Money            getBalance();
    Money            getTotalRevenue();
    IInventory       getInventory();
    void             restock(String slotId, int amount);
}
