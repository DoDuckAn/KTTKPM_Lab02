package order_management.state;

public class ProcessingState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("[PROCESSING] Package and ship order " + context.getOrderId());
    }

    @Override
    public void next(OrderContext context) {
        context.setState(new DeliveredState());
    }

    @Override
    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
    }

    @Override
    public String name() {
        return "PROCESSING";
    }
}
