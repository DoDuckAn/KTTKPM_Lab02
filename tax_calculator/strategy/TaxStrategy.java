package tax_calculator.strategy;

public interface TaxStrategy {
    double calculate(double amount);
    String name();
}
