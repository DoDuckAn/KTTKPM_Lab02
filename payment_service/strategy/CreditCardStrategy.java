package payment_service.strategy;

public class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Thanh toan Credit Card " + mask(cardNumber) + " so tien " + amount);
        return amount > 0;
    }

    @Override
    public String name() {
        return "Credit Card";
    }

    private String mask(String value) {
        if (value.length() <= 4) {
            return value;
        }
        return "****" + value.substring(value.length() - 4);
    }
}
