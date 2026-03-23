package order_management.decorator;

public class RetryDecorator extends OrderHandlerDecorator {
    private final int maxAttempts;

    public RetryDecorator(OrderHandler delegate, int maxAttempts) {
        super(delegate);
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void handle(OrderRequest request) {
        int attempts = 0;
        while (true) {
            try {
                attempts++;
                delegate.handle(request);
                return;
            } catch (RuntimeException ex) {
                if (attempts >= maxAttempts) {
                    throw ex;
                }
                System.out.println("[RETRY] Attempt " + attempts + " failed for " + request.getOrderId());
            }
        }
    }
}
