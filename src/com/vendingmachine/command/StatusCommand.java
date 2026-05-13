package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;

public class StatusCommand extends AbstractCommand {
    public StatusCommand() { super("status", "Show balance and revenue", "status"); }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        display.showStatus(controller.getBalance(), controller.getTotalRevenue());
        return true;
    }
}
