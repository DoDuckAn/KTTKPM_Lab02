package tax_calculator.decorator;

public class VatTaxDecorator extends TaxDecorator {
    public VatTaxDecorator(TaxComponent wrapped) {
        super(wrapped);
    }

    @Override
    public double total(double baseAmount) {
        return wrapped.total(baseAmount) + baseAmount * 0.10;
    }

    @Override
    public String breakdown() {
        return wrapped.breakdown() + " + VAT(10%)";
    }
}
