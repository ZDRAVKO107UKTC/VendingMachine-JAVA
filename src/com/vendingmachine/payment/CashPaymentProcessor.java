package com.vendingmachine.payment;

import com.vendingmachine.model.Money;

public class CashPaymentProcessor implements IPaymentProcessor {
    private Money balance = Money.zero();

    @Override
    public void insert(Money amount) {
        if (amount.getCents() <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance = balance.add(amount);
    }

    @Override public Money getBalance() { return balance; }

    @Override
    public void deduct(Money amount) { balance = balance.subtract(amount); }

    @Override
    public Money returnBalance() {
        Money returned = balance;
        balance = Money.zero();
        return returned;
    }
}
