interface Chair {
  describe(): string;
}

interface CoffeeTable {
  describe(): string;
}

interface FurnitureFactory {
  createChair(): Chair;
  createCoffeeTable(): CoffeeTable;
}

class ModernChair implements Chair {
  describe(): string {
    return "Modern chair with a clean silhouette and metal legs.";
  }
}

class ModernCoffeeTable implements CoffeeTable {
  describe(): string {
    return "Modern coffee table with glass top and minimal frame.";
  }
}

class VictorianChair implements Chair {
  describe(): string {
    return "Victorian chair with carved wood and a tall backrest.";
  }
}

class VictorianCoffeeTable implements CoffeeTable {
  describe(): string {
    return "Victorian coffee table with ornate details and curved legs.";
  }
}

class ModernFurnitureFactory implements FurnitureFactory {
  createChair(): Chair {
    return new ModernChair();
  }

  createCoffeeTable(): CoffeeTable {
    return new ModernCoffeeTable();
  }
}

class VictorianFurnitureFactory implements FurnitureFactory {
  createChair(): Chair {
    return new VictorianChair();
  }

  createCoffeeTable(): CoffeeTable {
    return new VictorianCoffeeTable();
  }
}

function showRoom(factoryName: string, factory: FurnitureFactory): void {
  const chair = factory.createChair();
  const coffeeTable = factory.createCoffeeTable();

  console.log(`${factoryName} chair: ${chair.describe()}`);
  console.log(`${factoryName} coffee table: ${coffeeTable.describe()}`);
}

export function runAbstractFactoryDemo(): void {
  showRoom("Modern", new ModernFurnitureFactory());
  showRoom("Victorian", new VictorianFurnitureFactory());
}

if (require.main === module) {
  runAbstractFactoryDemo();
}