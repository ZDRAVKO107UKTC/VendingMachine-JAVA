package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;
import com.vendingmachine.model.DispensingResult;

public class SelectCommand extends AbstractCommand {
    public SelectCommand() { super("select", "Buy a product", "select <slot>  e.g. select A1"); }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        if (args.length < 1) { showUsageError(display); return true; }
        DispensingResult result = controller.selectProduct(args[0]);
        display.showDispensingResult(result);
        return true;
    }
}
