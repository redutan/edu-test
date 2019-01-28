package com.example.test.practice.refund;

/**
 * @author myeongju.jung
 */
public class Order {
    private long amount;

    public Order(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "Order{" +
               "amount=" + amount +
               '}';
    }
}

