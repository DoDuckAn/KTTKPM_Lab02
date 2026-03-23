package order_management.strategy;

public class ProcessingOrderStrategy implements OrderStrategy {
    @Override
    public void process(String orderId) {
        System.out.println("[PROCESSING] Package and ship order " + orderId);
    }

    @Override
    public String name() {
        return "PROCESSING";
    }
}
