package payment_service.decorator;

public class Main {
    public static void main(String[] args) {
        AmountComponent base = new BaseAmount(1000000);
        AmountComponent withFee = new ProcessingFeeDecorator(base, 0.03);
        AmountComponent finalAmount = new DiscountDecorator(withFee, 0.10);

        System.out.println("Chi tiet: " + finalAmount.detail());
        System.out.println("Tong thanh toan: " + finalAmount.value());

        AmountComponent paypalFlow = new DiscountDecorator(
                new ProcessingFeeDecorator(new BaseAmount(800000), 0.05),
                0.08
        );

        System.out.println("Chi tiet: " + paypalFlow.detail());
        System.out.println("Tong thanh toan: " + paypalFlow.value());
    }
}
