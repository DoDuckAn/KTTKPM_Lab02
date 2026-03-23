package payment_service.state;

public class ProcessingState implements PaymentState {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("Thanh toan dang duoc xu ly");
    }

    @Override
    public void complete(PaymentContext context) {
        context.setState(new CompletedState());
        System.out.println("Thanh toan hoan tat " + context.getPaymentId());
    }

    @Override
    public void fail(PaymentContext context) {
        context.setState(new FailedState());
        System.out.println("Thanh toan that bai " + context.getPaymentId());
    }

    @Override
    public void retry(PaymentContext context) {
        System.out.println("Dang xu ly, chua the retry");
    }

    @Override
    public String name() {
        return "DANG_XU_LY";
    }
}
