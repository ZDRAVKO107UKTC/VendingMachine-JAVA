package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;

public class RestockCommand extends AbstractCommand {
    public RestockCommand() {
        super("restock", "Restock a slot", "restock <slot> <amount>  e.g. restock A1 5");
    }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        if (args.length < 2) { showUsageError(display); return true; }
        try {
            int amount = Integer.parseInt(args[1]);
            controller.restock(args[0], amount);
            display.showMessage("Restocked " + args[0].toUpperCase() + " with " + amount + " units.");
        } catch (NumberFormatException e) {
            showUsageError(display);
        } catch (IllegalArgumentException e) {
            display.showMessage(e.getMessage());
        }
        return true;
    }
}
