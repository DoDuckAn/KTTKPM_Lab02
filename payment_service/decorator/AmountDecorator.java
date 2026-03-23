package payment_service.decorator;

public abstract class AmountDecorator implements AmountComponent {
    protected final AmountComponent wrapped;

    protected AmountDecorator(AmountComponent wrapped) {
        this.wrapped = wrapped;
    }
}
