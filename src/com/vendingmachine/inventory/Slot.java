package com.vendingmachine.inventory;

import com.vendingmachine.product.IProduct;

public class Slot implements ISlot {
    private final String   id;
    private final IProduct product;
    private       int      quantity;

    public Slot(String id, IProduct product, int quantity) {
        this.id       = id.toUpperCase();
        this.product  = product;
        this.quantity = quantity;
    }

    @Override public String   getId()         { return id; }
    @Override public IProduct getProduct()    { return product; }
    @Override public int      getQuantity()   { return quantity; }
    @Override public boolean  isAvailable()   { return quantity > 0; }

    @Override
    public void dispense() {
        if (!isAvailable()) throw new IllegalStateException("Slot " + id + " is out of stock");
        quantity--;
    }

    @Override
    public void restock(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Restock amount must be positive");
        quantity += amount;
    }
}
