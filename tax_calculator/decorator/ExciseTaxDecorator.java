package tax_calculator.decorator;

public class ExciseTaxDecorator extends TaxDecorator {
    public ExciseTaxDecorator(TaxComponent wrapped) {
        super(wrapped);
    }

    @Override
    public double total(double baseAmount) {
        return wrapped.total(baseAmount) + baseAmount * 0.15;
    }

    @Override
    public String breakdown() {
        return wrapped.breakdown() + " + Thue tieu thu(15%)";
    }
}
