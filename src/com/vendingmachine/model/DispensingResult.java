package com.vendingmachine.model;

import com.vendingmachine.product.IProduct;

public final class DispensingResult {

    public enum Status { SUCCESS, INSUFFICIENT_FUNDS, OUT_OF_STOCK, INVALID_SLOT }

    private final Status   status;
    private final IProduct product;
    private final Money    change;
    private final String   message;

    private DispensingResult(Status status, IProduct product, Money change, String message) {
        this.status  = status;
        this.product = product;
        this.change  = change;
        this.message = message;
    }

    public static DispensingResult success(IProduct product, Money change) {
        return new DispensingResult(Status.SUCCESS, product, change,
            "Dispensing: " + product.getName() + "  |  Change: " + change);
    }

    public static DispensingResult insufficientFunds(Money shortage) {
        return new DispensingResult(Status.INSUFFICIENT_FUNDS, null, Money.zero(),
            "Insufficient funds. Need " + shortage + " more.");
    }

    public static DispensingResult outOfStock(String productName) {
        return new DispensingResult(Status.OUT_OF_STOCK, null, Money.zero(),
            productName + " is out of stock.");
    }

    public static DispensingResult invalidSlot(String slotId) {
        return new DispensingResult(Status.INVALID_SLOT, null, Money.zero(),
            "Invalid slot: " + slotId);
    }

    public boolean isSuccess()   { return status == Status.SUCCESS; }
    public Status  getStatus()   { return status; }
    public IProduct getProduct() { return product; }
    public Money   getChange()   { return change; }
    public String  getMessage()  { return message; }
}
