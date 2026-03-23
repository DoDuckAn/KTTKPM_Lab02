package order_management.decorator;

public abstract class OrderHandlerDecorator implements OrderHandler {
    protected final OrderHandler delegate;

    protected OrderHandlerDecorator(OrderHandler delegate) {
        this.delegate = delegate;
    }
}
