package org.example;

public class Main {
    public static void main(String[] args) {
        WorkflowEngine engine = new WorkflowEngine();
        Order order = new Order("12345");
        OrderContext orderContext = new OrderContext(order);

        engine.start(orderContext);
    }
}