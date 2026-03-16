interface OrderState {
  getName(): string;
  pay(context: OrderContext): string;
  ship(context: OrderContext): string;
  deliver(context: OrderContext): string;
  cancel(context: OrderContext): string;
}

class OrderContext {
  private state: OrderState;

  constructor() {
    this.state = new PendingState();
  }

  setState(state: OrderState): void {
    this.state = state;
  }

  getStateName(): string {
    return this.state.getName();
  }

  pay(): void {
    this.execute((state) => state.pay(this));
  }

  ship(): void {
    this.execute((state) => state.ship(this));
  }

  deliver(): void {
    this.execute((state) => state.deliver(this));
  }

  cancel(): void {
    this.execute((state) => state.cancel(this));
  }

  private execute(action: (state: OrderState) => string): void {
    console.log(action(this.state));
    console.log(`Current state: ${this.getStateName()}`);
  }
}

class PendingState implements OrderState {
  getName(): string {
    return "Pending";
  }

  pay(context: OrderContext): string {
    context.setState(new PaidState());
    return "Payment accepted.";
  }

  ship(): string {
    return "Order must be paid before shipping.";
  }

  deliver(): string {
    return "Order must be shipped before delivery.";
  }

  cancel(context: OrderContext): string {
    context.setState(new CancelledState());
    return "Order cancelled while pending.";
  }
}

class PaidState implements OrderState {
  getName(): string {
    return "Paid";
  }

  pay(): string {
    return "Order is already paid.";
  }

  ship(context: OrderContext): string {
    context.setState(new ShippedState());
    return "Order shipped to customer.";
  }

  deliver(): string {
    return "Order must be shipped before delivery.";
  }

  cancel(context: OrderContext): string {
    context.setState(new CancelledState());
    return "Order refunded and cancelled.";
  }
}

class ShippedState implements OrderState {
  getName(): string {
    return "Shipped";
  }

  pay(): string {
    return "No payment action needed after shipping.";
  }

  ship(): string {
    return "Order has already been shipped.";
  }

  deliver(context: OrderContext): string {
    context.setState(new DeliveredState());
    return "Order delivered successfully.";
  }

  cancel(): string {
    return "Order cannot be cancelled after shipping.";
  }
}

class DeliveredState implements OrderState {
  getName(): string {
    return "Delivered";
  }

  pay(): string {
    return "Delivered orders do not require payment.";
  }

  ship(): string {
    return "Delivered orders cannot be shipped again.";
  }

  deliver(): string {
    return "Order has already been delivered.";
  }

  cancel(): string {
    return "Delivered orders cannot be cancelled.";
  }
}

class CancelledState implements OrderState {
  getName(): string {
    return "Cancelled";
  }

  pay(): string {
    return "Cancelled orders cannot be paid.";
  }

  ship(): string {
    return "Cancelled orders cannot be shipped.";
  }

  deliver(): string {
    return "Cancelled orders cannot be delivered.";
  }

  cancel(): string {
    return "Order is already cancelled.";
  }
}

export function runStateDemo(): void {
  const order = new OrderContext();

  console.log(`Initial state: ${order.getStateName()}`);
  order.pay();
  order.ship();
  order.deliver();
  order.cancel();
}

if (require.main === module) {
  runStateDemo();
}