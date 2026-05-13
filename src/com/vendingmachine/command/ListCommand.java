package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;

public class ListCommand extends AbstractCommand {
    public ListCommand() { super("list", "Show all products", "list"); }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        display.showInventory(controller.getInventory());
        return true;
    }
}
