package tax_calculator.state;

public interface TaxState {
    double tax(double amount);
    String name();
    TaxState next();
}
