interface Beverage {
  getDescription(): string;
  getCost(): number;
}

class Espresso implements Beverage {
  getDescription(): string {
    return "Espresso";
  }

  getCost(): number {
    return 2;
  }
}

abstract class BeverageAddon implements Beverage {
  constructor(protected readonly beverage: Beverage) {}

  getDescription(): string {
    return this.beverage.getDescription();
  }

  getCost(): number {
    return this.beverage.getCost();
  }
}

class MilkAddon extends BeverageAddon {
  getDescription(): string {
    return `${super.getDescription()}, milk`;
  }

  getCost(): number {
    return super.getCost() + 0.5;
  }
}

class CaramelAddon extends BeverageAddon {
  getDescription(): string {
    return `${super.getDescription()}, caramel`;
  }

  getCost(): number {
    return super.getCost() + 0.7;
  }
}

class WhippedCreamAddon extends BeverageAddon {
  getDescription(): string {
    return `${super.getDescription()}, whipped cream`;
  }

  getCost(): number {
    return super.getCost() + 0.6;
  }
}

function printOrder(label: string, beverage: Beverage): void {
  console.log(`${label}: ${beverage.getDescription()} -> $${beverage.getCost().toFixed(2)}`);
}

export function runDecoratorDemo(): void {
  const basicCoffee = new Espresso();
  const premiumCoffee = new WhippedCreamAddon(new CaramelAddon(new MilkAddon(new Espresso())));

  printOrder("Basic order", basicCoffee);
  printOrder("Premium order", premiumCoffee);
}

if (require.main === module) {
  runDecoratorDemo();
}