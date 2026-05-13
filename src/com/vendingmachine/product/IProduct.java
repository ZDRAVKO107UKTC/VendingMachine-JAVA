package com.vendingmachine.product;

import com.vendingmachine.model.Money;

public interface IProduct {
    String getName();
    Money  getPrice();
    String getCategory();
}
