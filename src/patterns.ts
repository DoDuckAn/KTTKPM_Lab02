import { runAbstractFactoryDemo } from "./AbstractFactory";
import { runDecoratorDemo } from "./Decorator";
import { runFactoryDemo } from "./Factory";
import { runObserverDemo } from "./Observer";
import { runStateDemo } from "./State";

const demos: Array<{ title: string; run: () => void }> = [
  { title: "Factory Pattern", run: runFactoryDemo },
  { title: "Abstract Factory Pattern", run: runAbstractFactoryDemo },
  { title: "Decorator Pattern", run: runDecoratorDemo },
  { title: "State Pattern", run: runStateDemo },
  { title: "Observer Pattern", run: runObserverDemo }
];

demos.forEach((demo, index) => {
  console.log(`=== ${demo.title} ===`);
  demo.run();

  if (index < demos.length - 1) {
    console.log("");
  }
});