package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;

public class ReturnCommand extends AbstractCommand {
    public ReturnCommand() { super("return", "Return inserted money", "return"); }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        display.showMessage("Returned: " + controller.returnChange());
        return true;
    }
}
