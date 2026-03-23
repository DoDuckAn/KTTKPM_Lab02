package tax_calculator.decorator;

public interface TaxComponent {
    double total(double baseAmount);
    String breakdown();
}
