package com.vendingmachine.command;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRegistry implements ICommandRegistry {
    private final Map<String, ICommand> commands = new LinkedHashMap<>();

    @Override
    public void register(ICommand command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    @Override
    public Optional<ICommand> find(String name) {
        return Optional.ofNullable(commands.get(name.toLowerCase()));
    }

    @Override
    public Collection<ICommand> getAll() {
        return commands.values();
    }
}
