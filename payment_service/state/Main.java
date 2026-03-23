package payment_service.state;

public class Main {
    public static void main(String[] args) {
        PaymentContext payment = new PaymentContext("PAY-1001", 1200000);
        System.out.println("Trang thai: " + payment.status());

        payment.pay();
        System.out.println("Trang thai: " + payment.status());

        payment.fail();
        System.out.println("Trang thai: " + payment.status());

        payment.retry();
        System.out.println("Trang thai: " + payment.status());

        payment.complete();
        System.out.println("Trang thai: " + payment.status());
    }
}
