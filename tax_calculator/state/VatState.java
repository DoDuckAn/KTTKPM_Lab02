package tax_calculator.state;

public class VatState implements TaxState {
    @Override
    public double tax(double amount) {
        return amount * 0.10;
    }

    @Override
    public String name() {
        return "VAT";
    }

    @Override
    public TaxState next() {
        return new ExciseState();
    }
}
