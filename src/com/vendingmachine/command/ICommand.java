package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;

public interface ICommand {
    String  getName();
    String  getDescription();
    String  getUsage();
    /** @return false to signal the application should exit */
    boolean execute(String[] args, IVendingMachineController controller, IDisplay display);
}
