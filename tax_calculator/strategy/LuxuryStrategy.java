package tax_calculator.strategy;

public class LuxuryStrategy implements TaxStrategy {
    @Override
    public double calculate(double amount) {
        return amount * 0.25;
    }

    @Override
    public String name() {
        return "THUE_XA_XI";
    }
}
