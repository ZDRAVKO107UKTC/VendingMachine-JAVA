package com.vendingmachine.display;

import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.inventory.ISlot;
import com.vendingmachine.model.DispensingResult;
import com.vendingmachine.model.Money;

public class ConsoleDisplay implements IDisplay {

    @Override
    public void showInventory(IInventory inventory) {
        System.out.println("+------+--------------------+----------+--------+-------+");
        System.out.println("| Slot | Product            | Category | Price  | Stock |");
        System.out.println("+------+--------------------+----------+--------+-------+");
        for (ISlot slot : inventory.getAllSlots()) {
            System.out.printf("| %-4s | %-18s | %-8s | %-6s | %-5d |%n",
                slot.getId(),
                slot.getProduct().getName(),
                slot.getProduct().getCategory(),
                slot.getProduct().getPrice(),
                slot.getQuantity());
        }
        System.out.println("+------+--------------------+----------+--------+-------+");
    }

    @Override public void showMessage(String message)         { System.out.println(message); }

    @Override
    public void showStatus(Money balance, Money revenue) {
        System.out.printf("Balance: %s  |  Total Revenue: %s%n", balance, revenue);
    }

    @Override
    public void showDispensingResult(DispensingResult result) {
        System.out.println(result.getMessage());
    }
}
