package com.vendingmachine.inventory;

import java.util.Collection;
import java.util.Optional;

public interface IInventory {
    void             addSlot(ISlot slot);
    Optional<ISlot>  findSlot(String slotId);
    Collection<ISlot> getAllSlots();
}
