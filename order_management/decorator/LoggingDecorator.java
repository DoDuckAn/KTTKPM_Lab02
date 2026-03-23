package order_management.decorator;

public class LoggingDecorator extends OrderHandlerDecorator {
    public LoggingDecorator(OrderHandler delegate) {
        super(delegate);
    }

    @Override
    public void handle(OrderRequest request) {
        System.out.println("[LOG] Start " + request.getOrderId() + " with status " + request.getStatus());
        delegate.handle(request);
        System.out.println("[LOG] End " + request.getOrderId());
    }
}
