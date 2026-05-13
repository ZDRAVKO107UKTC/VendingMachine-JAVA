package com.vendingmachine.inventory;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class VendingInventory implements IInventory {
    private final Map<String, ISlot> slots = new LinkedHashMap<>();

    @Override
    public void addSlot(ISlot slot) {
        slots.put(slot.getId().toUpperCase(), slot);
    }

    @Override
    public Optional<ISlot> findSlot(String slotId) {
        return Optional.ofNullable(slots.get(slotId.toUpperCase()));
    }

    @Override
    public Collection<ISlot> getAllSlots() {
        return slots.values();
    }
}
