package payment_service.state;

public class UnpaidState implements PaymentState {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("Bat dau thanh toan " + context.getPaymentId() + " so tien " + context.getAmount());
        context.setState(new ProcessingState());
    }

    @Override
    public void complete(PaymentContext context) {
        System.out.println("Khong the complete khi chua thanh toan");
    }

    @Override
    public void fail(PaymentContext context) {
        System.out.println("Khong the fail khi chua bat dau thanh toan");
    }

    @Override
    public void retry(PaymentContext context) {
        System.out.println("Khong can retry khi chua thanh toan");
    }

    @Override
    public String name() {
        return "CHUA_THANH_TOAN";
    }
}
