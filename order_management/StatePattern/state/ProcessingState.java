package order_management.StatePattern.state;

import order_management.StatePattern.model.Order;

public class ProcessingState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CanceledState());
    }

    @Override
    public String getStatus() {
        return "Order is in Processing state.";
    }
}
