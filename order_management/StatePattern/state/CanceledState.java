package KTTKPM_Lab02.order_management.StatePattern.state;

import KTTKPM_Lab02.order_management.StatePattern.model.Order;

public class CanceledState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order is canceled. No next state.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order is already canceled.");
    }

    @Override
    public String getStatus() {
        return "Order is in Canceled state.";
    }
}