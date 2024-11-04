package org.example.stateHandlers;

import org.example.OrderContext;
import java.util.function.Consumer;

public class PausedState implements OrderState {
    private final OrderState previousState;
    private Consumer<OrderContext> eventListener;

    public PausedState(OrderState previousState) {
        this.previousState = previousState;
    }

    @Override
    public void next(OrderContext context) {
        System.out.println("Order is paused and cannot proceed.");
    }

    @Override
    public void previous(OrderContext context) {
        System.out.println("Order is paused and cannot revert.");
    }

    @Override
    public void pause(OrderContext context) {
        System.out.println("Order is already paused.");
    }

    @Override
    public void resume(OrderContext context) {
        context.setState(previousState);
        context.next();
    }

    @Override
    public String getStateName() {
        return "Paused";
    }

    // Set an event listener for resuming from PausedState
    public void setEventListener(Consumer<OrderContext> listener) {
        this.eventListener = listener;
    }

    public void triggerResumeEvent(OrderContext context) {
        if (eventListener != null) {
            eventListener.accept(context);
        }
    }
}