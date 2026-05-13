package com.vendingmachine.model;

public final class Money implements Comparable<Money> {
    private final int cents;

    private Money(int cents) { this.cents = cents; }

    public static Money of(double dollars) { return new Money((int) Math.round(dollars * 100)); }
    public static Money zero()             { return new Money(0); }

    public Money add(Money other)      { return new Money(this.cents + other.cents); }
    public Money subtract(Money other) { return new Money(this.cents - other.cents); }

    public boolean isAtLeast(Money other) { return this.cents >= other.cents; }
    public boolean isZero()               { return cents == 0; }
    public int     getCents()             { return cents; }

    @Override public int compareTo(Money other) { return Integer.compare(this.cents, other.cents); }
    @Override public String toString()          { return String.format("$%.2f", cents / 100.0); }

    @Override
    public boolean equals(Object o) {
        return o instanceof Money && cents == ((Money) o).cents;
    }

    @Override public int hashCode() { return Integer.hashCode(cents); }
}
