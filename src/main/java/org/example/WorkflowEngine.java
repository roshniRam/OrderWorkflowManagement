package org.example;

import org.example.stateHandlers.PausedState;

public class WorkflowEngine {
    private boolean running = true;

    public void start(OrderContext orderContext) {
        while (running) {
            processOrder(orderContext);

            // Pause to simulate time passing between state transitions
            try {
                Thread.sleep(3000); // 1-second delay between transitions
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Workflow interrupted.");
                break;
            }
        }
    }

    private void processOrder(OrderContext orderContext) {
        if (orderContext.getCurrentState().getStateName().equals("Delivered")) {
            System.out.println("Order " + orderContext.getOrder() + " has been delivered. Stopping processing.");
            stop();
        } else if (orderContext.getCurrentState().getStateName().equals("Paused")) {
            System.out.println("Order " + orderContext.getOrder() + " is paused, waiting for external event to resume...");
            simulateExternalEvent(orderContext);
        } else {
            orderContext.next();
        }
    }

    private void simulateExternalEvent(OrderContext orderContext) {
        PausedState pausedState = (PausedState) orderContext.getCurrentState();
        pausedState.setEventListener(OrderContext::resume);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                orderContext.triggerResumeEvent();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public void stop() {
        running = false;
        System.out.println("Workflow engine stopped.");
    }
}


