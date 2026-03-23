package order_management.strategy;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        String orderId = "ORD-2001";

        processor.setStrategy(new NewOrderStrategy());
        processor.execute(orderId);

        processor.setStrategy(new ProcessingOrderStrategy());
        processor.execute(orderId);

        processor.setStrategy(new DeliveredOrderStrategy());
        processor.execute(orderId);

        processor.setStrategy(new CancelledOrderStrategy());
        processor.execute("ORD-2002");
    }
}
