package payment_service.state;

public interface PaymentState {
    void pay(PaymentContext context);
    void complete(PaymentContext context);
    void fail(PaymentContext context);
    void retry(PaymentContext context);
    String name();
}
