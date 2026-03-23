package payment_service.strategy;

public class PaypalStrategy implements PaymentStrategy {
    private final String email;

    public PaypalStrategy(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Thanh toan PayPal " + email + " so tien " + amount);
        return amount > 0;
    }

    @Override
    public String name() {
        return "PayPal";
    }
}
