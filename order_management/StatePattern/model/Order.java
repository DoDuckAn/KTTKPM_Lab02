package KTTKPM_Lab02.order_management.StatePattern.model;

import KTTKPM_Lab02.order_management.StatePattern.state.CreatedState;
import KTTKPM_Lab02.order_management.StatePattern.state.OrderState;

public class Order {
    private String orderId;
    private String userID;
    private OrderState state;

    public Order(String orderId, String userID) {
        this.orderId = orderId;
        this.userID = userID;
        this.state = new CreatedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getStatus() {
        return state.getStatus();
    }

    public void nextState() {
        state.next(this);
    }

    public void cancelOrder() {
        state.cancel(this);
    }

    // Getters and setters for orderId and userID
    public String getOrderId() {
        return orderId;
    }

    public String getUserID() {
        return userID;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userID='" + userID + '\'' +
                ", state=" + state.getStatus() +
                '}';
    }
}
