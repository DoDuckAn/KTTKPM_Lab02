package payment_service.strategy;

public interface PaymentStrategy {
    boolean pay(double amount);
    String name();
}
