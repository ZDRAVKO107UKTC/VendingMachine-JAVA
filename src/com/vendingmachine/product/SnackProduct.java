package com.vendingmachine.product;

import com.vendingmachine.model.Money;

public class SnackProduct extends Product {
    public SnackProduct(String name, Money price) { super(name, price); }
    @Override public String getCategory() { return "Snack"; }
}
