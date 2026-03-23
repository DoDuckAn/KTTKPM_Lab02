package tax_calculator.state;

public class ExciseState implements TaxState {
    @Override
    public double tax(double amount) {
        return amount * 0.15;
    }

    @Override
    public String name() {
        return "THUE_TIEU_THU";
    }

    @Override
    public TaxState next() {
        return new LuxuryState();
    }
}
