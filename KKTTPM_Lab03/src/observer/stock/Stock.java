package observer.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final String symbol;
    private double price;
    private final List<StockObserver> observers;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.observers = new ArrayList<>();
    }

    public void subscribe(StockObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}
