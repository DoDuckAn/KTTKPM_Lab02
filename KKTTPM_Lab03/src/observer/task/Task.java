package observer.task;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private final String title;
    private String status;
    private final List<TaskObserver> observers;

    public Task(String title) {
        this.title = title;
        this.status = "NOT_STARTED";
        this.observers = new ArrayList<>();
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.taskChanged(this);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }
}
