package org.example.stateHandlers;

import org.example.OrderContext;

public interface OrderState {
    void next(OrderContext context);
    void previous(OrderContext context);
    void pause(OrderContext context);
    void resume(OrderContext context);
    String getStateName();
}
