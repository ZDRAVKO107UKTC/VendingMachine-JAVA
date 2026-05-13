package com.vendingmachine.inventory;

import com.vendingmachine.product.IProduct;

public interface ISlot {
    String   getId();
    IProduct getProduct();
    int      getQuantity();
    boolean  isAvailable();
    void     dispense();
    void     restock(int amount);
}
