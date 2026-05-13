package com.vendingmachine.command;

import java.util.Collection;
import java.util.Optional;

public interface ICommandRegistry {
    void              register(ICommand command);
    Optional<ICommand> find(String name);
    Collection<ICommand> getAll();
}
