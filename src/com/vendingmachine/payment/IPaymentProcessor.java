package com.vendingmachine.payment;

import com.vendingmachine.model.Money;

public interface IPaymentProcessor {
    void  insert(Money amount);
    Money getBalance();
    void  deduct(Money amount);
    Money returnBalance();
}
