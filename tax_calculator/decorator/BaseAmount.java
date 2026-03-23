package tax_calculator.decorator;

public class BaseAmount implements TaxComponent {
    @Override
    public double total(double baseAmount) {
        return baseAmount;
    }

    @Override
    public String breakdown() {
        return "Gia goc";
    }
}
