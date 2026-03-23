package tax_calculator.strategy;

public class VatStrategy implements TaxStrategy {
    @Override
    public double calculate(double amount) {
        return amount * 0.10;
    }

    @Override
    public String name() {
        return "VAT";
    }
}
