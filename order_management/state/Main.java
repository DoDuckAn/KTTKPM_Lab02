package order_management.state;

public class Main {
    public static void main(String[] args) {
        OrderContext order = new OrderContext("ORD-1001");

        System.out.println("State: " + order.getStatus());
        order.execute();

        order.next();
        System.out.println("State: " + order.getStatus());
        order.execute();

        order.next();
        System.out.println("State: " + order.getStatus());
        order.execute();

        order.cancel();

        OrderContext cancelled = new OrderContext("ORD-1002");
        cancelled.execute();
        cancelled.cancel();
        System.out.println("State: " + cancelled.getStatus());
        cancelled.execute();
    }
}
