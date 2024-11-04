package org.example.stateHandlers;

import org.example.OrderContext;

public class ProcessingState implements OrderState {
    @Override
    public void next(OrderContext context) {
        context.setState(new PackingState());
    }

    @Override
    public void previous(OrderContext context) {
        System.out.println("Order is already in the initial state.");
    }

    @Override
    public void pause(OrderContext context) {
        context.setState(new PausedState(this));
    }

    @Override
    public void resume(OrderContext context) {
        System.out.println("Order is already in the Processing state.");
    }

    @Override
    public String getStateName() {
        return "Processing";
    }
}
