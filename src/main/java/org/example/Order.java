package org.example;

public class Order {
    private final String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order[ID=" + orderId + "]";
    }
}


