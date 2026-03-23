package tax_calculator.state;

public class Product {
    private final String name;
    private final double price;
    private TaxState state;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.state = new VatState();
    }

    public String getTaxType() {
        return state.name();
    }

    public void changeTaxType() {
        state = state.next();
    }

    public double calculateTax() {
        return state.tax(price);
    }

    public double totalPrice() {
        return price + calculateTax();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
