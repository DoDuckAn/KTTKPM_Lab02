package tax_calculator.state;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Nuoc hoa", 2000000);

        for (int i = 0; i < 3; i++) {
            System.out.println("Loai thue: " + product.getTaxType());
            System.out.println("Gia goc: " + product.getPrice());
            System.out.println("Tien thue: " + product.calculateTax());
            System.out.println("Tong tien: " + product.totalPrice());
            System.out.println("-----");
            product.changeTaxType();
        }
    }
}
