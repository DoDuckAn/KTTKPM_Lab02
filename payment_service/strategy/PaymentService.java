package payment_service.strategy;

public class PaymentService {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy is not set");
        }

        boolean result = strategy.pay(amount);
        System.out.println("Phuong thuc: " + strategy.name());
        System.out.println("Ket qua: " + (result ? "THANH_CONG" : "THAT_BAI"));
    }
}
