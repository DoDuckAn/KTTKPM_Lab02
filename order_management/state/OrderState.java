package order_management.state;

public interface OrderState {
    void handle(OrderContext context);
    void next(OrderContext context);
    void cancel(OrderContext context);
    String name();
}
