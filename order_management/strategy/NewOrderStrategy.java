package order_management.strategy;

public class NewOrderStrategy implements OrderStrategy {
    @Override
    public void process(String orderId) {
        System.out.println("[NEW] Validate order " + orderId);
    }

    @Override
    public String name() {
        return "NEW";
    }
}
