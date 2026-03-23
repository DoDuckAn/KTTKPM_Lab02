package payment_service.decorator;

public class ProcessingFeeDecorator extends AmountDecorator {
    private final double feePercent;

    public ProcessingFeeDecorator(AmountComponent wrapped, double feePercent) {
        super(wrapped);
        this.feePercent = feePercent;
    }

    @Override
    public double value() {
        double current = wrapped.value();
        return current + current * feePercent;
    }

    @Override
    public String detail() {
        return wrapped.detail() + " + Phi xu ly " + (feePercent * 100) + "%";
    }
}
