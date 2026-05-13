package com.vendingmachine.command;

import com.vendingmachine.display.IDisplay;

public abstract class AbstractCommand implements ICommand {
    private final String name;
    private final String description;
    private final String usage;

    protected AbstractCommand(String name, String description, String usage) {
        this.name        = name;
        this.description = description;
        this.usage       = usage;
    }

    @Override public String getName()        { return name; }
    @Override public String getDescription() { return description; }
    @Override public String getUsage()       { return usage; }

    protected void showUsageError(IDisplay display) {
        display.showMessage("Usage: " + usage);
    }
}
