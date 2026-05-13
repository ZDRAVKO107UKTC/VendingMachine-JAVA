package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;
import com.vendingmachine.model.Money;

public class InsertCommand extends AbstractCommand {
    public InsertCommand() { super("insert", "Insert money", "insert <amount>  e.g. insert 1.50"); }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        if (args.length < 1) { showUsageError(display); return true; }
        try {
            Money amount = Money.of(Double.parseDouble(args[0]));
            controller.insertMoney(amount);
            display.showMessage(String.format("  Inserted: %s  |  Balance: %s",
                amount, controller.getBalance()));
        } catch (NumberFormatException e) {
            showUsageError(display);
        } catch (IllegalArgumentException e) {
            display.showMessage(e.getMessage());
        }
        return true;
    }
}
