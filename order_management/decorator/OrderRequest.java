package order_management.decorator;

public class OrderRequest {
    private final String orderId;
    private final String status;
    private boolean failOnce;

    public OrderRequest(String orderId, String status, boolean failOnce) {
        this.orderId = orderId;
        this.status = status;
        this.failOnce = failOnce;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public boolean shouldFailNow() {
        if (failOnce) {
            failOnce = false;
            return true;
        }
        return false;
    }
}
