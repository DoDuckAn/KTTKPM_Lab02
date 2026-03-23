package order_management.decorator;

public class Main {
    public static void main(String[] args) {
        OrderHandler handler = new TrackingDecorator(
                new RetryDecorator(
                        new LoggingDecorator(new CoreOrderHandler()),
                        3
                )
        );

        handler.handle(new OrderRequest("ORD-3001", "NEW", false));
        handler.handle(new OrderRequest("ORD-3002", "PROCESSING", true));
        handler.handle(new OrderRequest("ORD-3003", "DELIVERED", false));
        handler.handle(new OrderRequest("ORD-3004", "CANCELLED", false));
    }
}
