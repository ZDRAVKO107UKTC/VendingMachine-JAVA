package com.vendingmachine.loader;

import com.vendingmachine.inventory.IInventory;

public interface IProductLoader {
    void load(IInventory inventory);
}
