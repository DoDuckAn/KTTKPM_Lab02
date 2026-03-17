package order_management.StatePattern.state;

import order_management.StatePattern.model.Order;

public interface OrderState {
    void next(Order order);
    void cancel(Order order);
    String getStatus();
}
