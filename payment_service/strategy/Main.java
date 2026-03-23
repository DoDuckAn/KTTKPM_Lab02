package payment_service.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.setStrategy(new CreditCardStrategy("4111111111111111"));
        service.checkout(500000);
        System.out.println("-----");

        service.setStrategy(new PaypalStrategy("buyer@example.com"));
        service.checkout(750000);
    }
}
