package org.example.stateHandlers;

import org.example.OrderContext;

public class DeliveredState implements OrderState {
    @Override
    public void next(OrderContext context) {
        System.out.println("Order is already delivered.");
    }

    @Override
    public void previous(OrderContext context) {
        context.setState(new ShippingState());
    }

    @Override
    public void pause(OrderContext context) {
        System.out.println("Delivered order cannot be paused.");
    }

    @Override
    public void resume(OrderContext context) {
        System.out.println("Delivered order cannot be resumed.");
    }

    @Override
    public String getStateName() {
        return "Delivered";
    }
}
