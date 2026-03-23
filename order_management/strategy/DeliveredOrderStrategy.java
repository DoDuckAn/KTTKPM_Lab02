package order_management.strategy;

public class DeliveredOrderStrategy implements OrderStrategy {
    @Override
    public void process(String orderId) {
        System.out.println("[DELIVERED] Confirm successful delivery for " + orderId);
    }

    @Override
    public String name() {
        return "DELIVERED";
    }
}
