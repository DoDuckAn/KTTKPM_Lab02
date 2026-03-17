package KTTKPM_Lab02.order_management.StatePattern.state;

import KTTKPM_Lab02.order_management.StatePattern.model.Order;

public class CreatedState implements OrderState {

    @Override
    public void next(Order order) {
        order.setState(new ProcessingState());
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CanceledState());
    }

    @Override
    public String getStatus() {
        return "Order is in Created state.";
    }
}
