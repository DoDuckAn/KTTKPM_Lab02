package payment_service.state;

public class CompletedState implements PaymentState {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("Thanh toan da hoan tat");
    }

    @Override
    public void complete(PaymentContext context) {
        System.out.println("Thanh toan da hoan tat");
    }

    @Override
    public void fail(PaymentContext context) {
        System.out.println("Khong the fail sau khi complete");
    }

    @Override
    public void retry(PaymentContext context) {
        System.out.println("Khong can retry vi da complete");
    }

    @Override
    public String name() {
        return "HOAN_TAT";
    }
}
