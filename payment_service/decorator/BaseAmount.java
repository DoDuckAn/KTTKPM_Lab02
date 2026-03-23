package payment_service.decorator;

public class BaseAmount implements AmountComponent {
    private final double amount;

    public BaseAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public double value() {
        return amount;
    }

    @Override
    public String detail() {
        return "So tien goc";
    }
}
