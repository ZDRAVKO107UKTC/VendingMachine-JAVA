package com.vendingmachine.revenue;

import com.vendingmachine.model.Money;

public class RevenueTracker implements IRevenueTracker {
    private Money total = Money.zero();

    @Override public void  record(Money amount) { total = total.add(amount); }
    @Override public Money getTotal()           { return total; }
}
