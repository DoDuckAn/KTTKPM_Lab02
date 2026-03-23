package tax_calculator.decorator;

public class Main {
    public static void main(String[] args) {
        double baseAmount = 3000000;

        TaxComponent onlyVat = new VatTaxDecorator(new BaseAmount());
        TaxComponent vatAndExcise = new ExciseTaxDecorator(new VatTaxDecorator(new BaseAmount()));
        TaxComponent allTaxes = new LuxuryTaxDecorator(new ExciseTaxDecorator(new VatTaxDecorator(new BaseAmount())));

        print("Chi VAT", onlyVat, baseAmount);
        print("VAT + Tieu thu", vatAndExcise, baseAmount);
        print("VAT + Tieu thu + Xa xi", allTaxes, baseAmount);
    }

    private static void print(String title, TaxComponent component, double baseAmount) {
        System.out.println(title);
        System.out.println("Cong thuc: " + component.breakdown());
        System.out.println("Gia goc: " + baseAmount);
        System.out.println("Tong sau thue: " + component.total(baseAmount));
        System.out.println("-----");
    }
}
