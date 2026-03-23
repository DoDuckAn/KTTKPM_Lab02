package order_management.decorator;

public class CoreOrderHandler implements OrderHandler {
    @Override
    public void handle(OrderRequest request) {
        if ("NEW".equals(request.getStatus())) {
            System.out.println("[NEW] Validate order " + request.getOrderId());
            return;
        }

        if ("PROCESSING".equals(request.getStatus())) {
            if (request.shouldFailNow()) {
                throw new IllegalStateException("Temporary shipping service error");
            }
            System.out.println("[PROCESSING] Package and ship order " + request.getOrderId());
            return;
        }

        if ("DELIVERED".equals(request.getStatus())) {
            System.out.println("[DELIVERED] Confirm successful delivery for " + request.getOrderId());
            return;
        }

        if ("CANCELLED".equals(request.getStatus())) {
            System.out.println("[CANCELLED] Cancel order and refund " + request.getOrderId());
            return;
        }

        throw new IllegalArgumentException("Unsupported status: " + request.getStatus());
    }
}
