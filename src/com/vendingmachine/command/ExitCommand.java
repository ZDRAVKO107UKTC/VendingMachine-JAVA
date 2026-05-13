package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() { super("exit", "Quit", "exit"); }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        display.showMessage("Goodbye!");
        return false;
    }
}
