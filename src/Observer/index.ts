interface StockObserver {
  update(productName: string, quantity: number): string;
}

class ProductStock {
  private observers: StockObserver[] = [];

  constructor(
    private readonly productName: string,
    private quantity: number
  ) {}

  addObserver(observer: StockObserver): void {
    this.observers.push(observer);
  }

  removeObserver(observer: StockObserver): void {
    this.observers = this.observers.filter((item) => item !== observer);
  }

  setQuantity(quantity: number): void {
    this.quantity = quantity;
    console.log(`Stock of ${this.productName} changed to ${this.quantity}.`);
    this.notifyObservers();
  }

  private notifyObservers(): void {
    this.observers.forEach((observer) => {
      console.log(observer.update(this.productName, this.quantity));
    });
  }
}

class WarehouseDashboard implements StockObserver {
  update(productName: string, quantity: number): string {
    return `Warehouse dashboard: ${productName} has ${quantity} item(s) left.`;
  }
}

class CustomerNotifier implements StockObserver {
  update(productName: string, quantity: number): string {
    if (quantity === 0) {
      return `Customer notifier: ${productName} is currently out of stock.`;
    }

    return `Customer notifier: ${productName} is available with ${quantity} item(s).`;
  }
}

class ProcurementService implements StockObserver {
  update(productName: string, quantity: number): string {
    if (quantity < 10) {
      return `Procurement service: reorder ${productName} soon.`;
    }

    return `Procurement service: stock level for ${productName} is healthy.`;
  }
}

export function runObserverDemo(): void {
  const stock = new ProductStock("Mechanical Keyboard", 25);
  const dashboard = new WarehouseDashboard();
  const customerNotifier = new CustomerNotifier();
  const procurementService = new ProcurementService();

  stock.addObserver(dashboard);
  stock.addObserver(customerNotifier);
  stock.addObserver(procurementService);

  stock.setQuantity(8);
  stock.setQuantity(0);
  stock.removeObserver(customerNotifier);
  stock.setQuantity(20);
}

if (require.main === module) {
  runObserverDemo();
}