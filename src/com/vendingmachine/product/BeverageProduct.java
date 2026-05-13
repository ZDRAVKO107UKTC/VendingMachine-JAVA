package com.vendingmachine.product;

import com.vendingmachine.model.Money;

public class BeverageProduct extends Product {
    public BeverageProduct(String name, Money price) { super(name, price); }
    @Override public String getCategory() { return "Beverage"; }
}
