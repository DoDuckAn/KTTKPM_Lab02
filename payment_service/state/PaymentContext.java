package payment_service.state;

public class PaymentContext {
    private final String paymentId;
    private final double amount;
    private PaymentState state;

    public PaymentContext(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.state = new UnpaidState();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String status() {
        return state.name();
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void pay() {
        state.pay(this);
    }

    public void complete() {
        state.complete(this);
    }

    public void fail() {
        state.fail(this);
    }

    public void retry() {
        state.retry(this);
    }
}
