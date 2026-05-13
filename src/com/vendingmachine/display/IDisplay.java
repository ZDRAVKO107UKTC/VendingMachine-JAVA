package com.vendingmachine.display;

import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.model.DispensingResult;
import com.vendingmachine.model.Money;

public interface IDisplay {
    void showInventory(IInventory inventory);
    void showMessage(String message);
    void showStatus(Money balance, Money revenue);
    void showDispensingResult(DispensingResult result);
}
