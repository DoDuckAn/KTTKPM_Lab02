package tax_calculator.strategy;

public class TaxCalculator {
    private TaxStrategy strategy;

    public void setStrategy(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public double tax(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Tax strategy is not set");
        }
        return strategy.calculate(amount);
    }

    public String strategyName() {
        if (strategy == null) {
            throw new IllegalStateException("Tax strategy is not set");
        }
        return strategy.name();
    }
}
