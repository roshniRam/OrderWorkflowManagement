package org.example.stateHandlers;

import org.example.OrderContext;

public class ShippingState implements OrderState {
    @Override
    public void next(OrderContext context) {
        context.setState(new DeliveredState());
    }

    @Override
    public void previous(OrderContext context) {
        context.setState(new PackingState());
    }

    @Override
    public void pause(OrderContext context) {
        context.setState(new PausedState(this));
    }

    @Override
    public void resume(OrderContext context) {
        System.out.println("Order is already being processed.");
    }

    @Override
    public String getStateName() {
        return "Shipping";
    }
}
