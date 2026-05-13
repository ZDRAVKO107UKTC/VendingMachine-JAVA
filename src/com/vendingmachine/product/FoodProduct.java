package com.vendingmachine.product;

import com.vendingmachine.model.Money;

public class FoodProduct extends Product {
    public FoodProduct(String name, Money price) { super(name, price); }
    @Override public String getCategory() { return "Food"; }
}
