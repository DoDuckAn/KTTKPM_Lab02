package order_management.state;

public class DeliveredState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("[DELIVERED] Confirm successful delivery for " + context.getOrderId());
    }

    @Override
    public void next(OrderContext context) {
        System.out.println("Order " + context.getOrderId() + " is already DELIVERED");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("Cannot cancel delivered order " + context.getOrderId());
    }

    @Override
    public String name() {
        return "DELIVERED";
    }
}
