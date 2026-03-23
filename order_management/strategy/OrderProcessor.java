package order_management.strategy;

public class OrderProcessor {
    private OrderStrategy strategy;

    public void setStrategy(OrderStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(String orderId) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not set");
        }
        System.out.println("Strategy: " + strategy.name());
        strategy.process(orderId);
    }
}
