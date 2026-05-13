package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;
import com.vendingmachine.machine.IVendingMachineController;

public class HelpCommand extends AbstractCommand {
    private final ICommandRegistry registry;

    public HelpCommand(ICommandRegistry registry) {
        super("help", "Show this help", "help");
        this.registry = registry;
    }

    @Override
    public boolean execute(String[] args, IVendingMachineController controller, IDisplay display) {
        display.showMessage("Commands:");
        for (ICommand cmd : registry.getAll()) {
            display.showMessage(String.format("  %-8s - %s", cmd.getName(), cmd.getDescription()));
        }
        return true;
    }
}
