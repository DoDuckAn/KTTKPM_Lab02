package order_management.decorator;

public class TrackingDecorator extends OrderHandlerDecorator {
    public TrackingDecorator(OrderHandler delegate) {
        super(delegate);
    }

    @Override
    public void handle(OrderRequest request) {
        System.out.println("[TRACKING] Tracking event for order " + request.getOrderId());
        delegate.handle(request);
    }
}
