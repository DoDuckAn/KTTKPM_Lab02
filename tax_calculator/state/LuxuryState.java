package tax_calculator.state;

public class LuxuryState implements TaxState {
    @Override
    public double tax(double amount) {
        return amount * 0.25;
    }

    @Override
    public String name() {
        return "THUE_XA_XI";
    }

    @Override
    public TaxState next() {
        return new VatState();
    }
}
