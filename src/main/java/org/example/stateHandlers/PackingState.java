package org.example.stateHandlers;

import org.example.OrderContext;

public class PackingState implements OrderState {
    private boolean hasPaused = false;

    @Override
    public void next(OrderContext context) {
        if (!hasPaused) {
            context.setState(new PausedState(this));
            this.hasPaused = true; // Ensure pause happens only once
        } else {
            context.setState(new ShippingState());
        }
    }

    @Override
    public void previous(OrderContext context) {
        context.setState(new ProcessingState());
    }

    @Override
    public void pause(OrderContext context) {
        context.setState(new PausedState(this));
    }

    @Override
    public void resume(OrderContext context) {
        System.out.println("Order is already in Packing state.");
    }

    @Override
    public String getStateName() {
        return "Packing";
    }
}
