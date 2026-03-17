package KTTKPM_Lab02.order_management.StatePattern.state;

import KTTKPM_Lab02.order_management.StatePattern.model.Order;

public interface OrderState {
    void next(Order order);
    void cancel(Order order);
    String getStatus();
}
