package payment_service.state;

public class FailedState implements PaymentState {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("Thanh toan da that bai, hay retry");
    }

    @Override
    public void complete(PaymentContext context) {
        System.out.println("Khong the complete khi dang o trang thai that bai");
    }

    @Override
    public void fail(PaymentContext context) {
        System.out.println("Thanh toan da that bai");
    }

    @Override
    public void retry(PaymentContext context) {
        context.setState(new ProcessingState());
        System.out.println("Thu lai thanh toan " + context.getPaymentId());
    }

    @Override
    public String name() {
        return "THAT_BAI";
    }
}
