package payment_service.decorator;

public class DiscountDecorator extends AmountDecorator {
    private final double discountPercent;

    public DiscountDecorator(AmountComponent wrapped, double discountPercent) {
        super(wrapped);
        this.discountPercent = discountPercent;
    }

    @Override
    public double value() {
        double current = wrapped.value();
        double discounted = current - current * discountPercent;
        return Math.max(0, discounted);
    }

    @Override
    public String detail() {
        return wrapped.detail() + " - Giam gia " + (discountPercent * 100) + "%";
    }
}
