package com.vendingmachine.loader;

import com.vendingmachine.inventory.IInventory;
import com.vendingmachine.inventory.Slot;
import com.vendingmachine.model.Money;
import com.vendingmachine.product.BeverageProduct;
import com.vendingmachine.product.FoodProduct;
import com.vendingmachine.product.SnackProduct;

public class DefaultProductLoader implements IProductLoader {

    @Override
    public void load(IInventory inventory) {
        inventory.addSlot(new Slot("A1", new BeverageProduct("Cola",         Money.of(1.50)), 5));
        inventory.addSlot(new Slot("A2", new BeverageProduct("Diet Cola",    Money.of(1.50)), 5));
        inventory.addSlot(new Slot("A3", new BeverageProduct("Orange Juice", Money.of(2.00)), 4));
        inventory.addSlot(new Slot("A4", new BeverageProduct("Water",        Money.of(1.00)), 8));
        inventory.addSlot(new Slot("B1", new SnackProduct("Chips",           Money.of(1.25)), 6));
        inventory.addSlot(new Slot("B2", new SnackProduct("Pretzels",        Money.of(1.25)), 6));
        inventory.addSlot(new Slot("B3", new SnackProduct("Granola Bar",     Money.of(1.75)), 4));
        inventory.addSlot(new Slot("B4", new SnackProduct("Chocolate",       Money.of(2.00)), 5));
        inventory.addSlot(new Slot("B5", new SnackProduct("Gummy Bears",     Money.of(1.50)), 3));
        inventory.addSlot(new Slot("C1", new FoodProduct("Sandwich",         Money.of(4.50)), 3));
        inventory.addSlot(new Slot("C2", new FoodProduct("Salad",            Money.of(5.00)), 2));
        inventory.addSlot(new Slot("C3", new FoodProduct("Yogurt",           Money.of(2.50)), 4));
    }
}
