package order_management.strategy;

public class CancelledOrderStrategy implements OrderStrategy {
    @Override
    public void process(String orderId) {
        System.out.println("[CANCELLED] Cancel order and refund " + orderId);
    }

    @Override
    public String name() {
        return "CANCELLED";
    }
}
