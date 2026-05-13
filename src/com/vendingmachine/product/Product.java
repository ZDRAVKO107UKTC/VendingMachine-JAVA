package com.vendingmachine.product;

import com.vendingmachine.model.Money;

public abstract class Product implements IProduct {
    private final String name;
    private final Money  price;

    protected Product(String name, Money price) {
        this.name  = name;
        this.price = price;
    }

    @Override public String getName()  { return name; }
    @Override public Money  getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s [%s] %s", name, getCategory(), price);
    }
}
