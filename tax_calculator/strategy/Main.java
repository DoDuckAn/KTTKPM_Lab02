package tax_calculator.strategy;

public class Main {
    public static void main(String[] args) {
        double amount = 1500000;
        TaxCalculator calculator = new TaxCalculator();

        calculator.setStrategy(new VatStrategy());
        printTax(calculator, amount);

        calculator.setStrategy(new ExciseStrategy());
        printTax(calculator, amount);

        calculator.setStrategy(new LuxuryStrategy());
        printTax(calculator, amount);
    }

    private static void printTax(TaxCalculator calculator, double amount) {
        double tax = calculator.tax(amount);
        System.out.println("Loai thue: " + calculator.strategyName());
        System.out.println("Gia tri tinh thue: " + amount);
        System.out.println("Tien thue: " + tax);
        System.out.println("Tong tien: " + (amount + tax));
        System.out.println("-----");
    }
}
