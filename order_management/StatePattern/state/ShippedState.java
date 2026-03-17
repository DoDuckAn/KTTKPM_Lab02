package KTTKPM_Lab02.order_management.StatePattern.state;

import KTTKPM_Lab02.order_management.StatePattern.model.Order;

public class ShippedState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order is already shipped. No next state.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CanceledState());
    }

    @Override
    public String getStatus() {
        return "Order is in Shipped state.";
    }
}
