package order_management.state;

public class OrderContext {
    private final String orderId;
    private OrderState state;

    public OrderContext(String orderId) {
        this.orderId = orderId;
        this.state = new NewState();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getStatus() {
        return state.name();
    }

    public void execute() {
        state.handle(this);
    }

    public void next() {
        state.next(this);
    }

    public void cancel() {
        state.cancel(this);
    }
}
