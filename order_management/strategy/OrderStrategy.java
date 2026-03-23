package order_management.strategy;

public interface OrderStrategy {
    void process(String orderId);
    String name();
}
