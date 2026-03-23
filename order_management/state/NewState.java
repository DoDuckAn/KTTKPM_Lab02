package order_management.state;

public class NewState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("[NEW] Validate order " + context.getOrderId());
    }

    @Override
    public void next(OrderContext context) {
        context.setState(new ProcessingState());
    }

    @Override
    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
    }

    @Override
    public String name() {
        return "NEW";
    }
}
