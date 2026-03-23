package tax_calculator.decorator;

public class LuxuryTaxDecorator extends TaxDecorator {
    public LuxuryTaxDecorator(TaxComponent wrapped) {
        super(wrapped);
    }

    @Override
    public double total(double baseAmount) {
        return wrapped.total(baseAmount) + baseAmount * 0.25;
    }

    @Override
    public String breakdown() {
        return wrapped.breakdown() + " + Thue xa xi(25%)";
    }
}
