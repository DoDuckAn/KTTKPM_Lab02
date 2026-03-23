package order_management.state;

public class CancelledState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("[CANCELLED] Cancel order and refund " + context.getOrderId());
    }

    @Override
    public void next(OrderContext context) {
        System.out.println("Order " + context.getOrderId() + " is already CANCELLED");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("Order " + context.getOrderId() + " is already CANCELLED");
    }

    @Override
    public String name() {
        return "CANCELLED";
    }
}
