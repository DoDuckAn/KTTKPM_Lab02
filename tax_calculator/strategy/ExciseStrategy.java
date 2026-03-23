package tax_calculator.strategy;

public class ExciseStrategy implements TaxStrategy {
    @Override
    public double calculate(double amount) {
        return amount * 0.15;
    }

    @Override
    public String name() {
        return "THUE_TIEU_THU";
    }
}
