package org.example;

import org.example.stateHandlers.OrderState;
import org.example.stateHandlers.PausedState;

import org.example.stateHandlers.ProcessingState;

public class OrderContext {
    private final Order order;
    private OrderState state;

    public OrderContext(Order order) {
        this.order = order;
        this.state = new ProcessingState();
    }

    public Order getOrder() {
        return order;
    }

    public void setState(OrderState state) {
        this.state = state;
        System.out.println("Order " + order + " is now in " + state.getStateName() + " state.");
    }

    public void next() {
        state.next(this);
    }

    public void previous() {
        state.previous(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void resume() {
        state.resume(this);
    }

    public OrderState getCurrentState() {
        return state;
    }

    // Method to trigger the resume event if the order is in PausedState
    public void triggerResumeEvent() {
        if (state instanceof PausedState) {
            ((PausedState) state).triggerResumeEvent(this);
        } else {
            System.out.println("Order is not in a paused state.");
        }
    }
}

