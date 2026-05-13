package com.vendingmachine.revenue;

import com.vendingmachine.model.Money;

public interface IRevenueTracker {
    void  record(Money amount);
    Money getTotal();
}
