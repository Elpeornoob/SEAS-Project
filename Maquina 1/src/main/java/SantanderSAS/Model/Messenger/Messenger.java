package SantanderSAS.Model.Messenger;

import SantanderSAS.Model.Observer.Observer;
import bryan.array.Array;

import java.io.Serializable;

public class Messenger implements Serializable {
    private String message;
    private final Array<Observer<Messenger>> observers;

    public Messenger(String message) {
        this.message = message;
        observers = new Array<>(10);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyAllObservers();
    }

    public void attach(Observer<Messenger> observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(observer -> {
            if (observer != null) {
                observer.update();
            }
            return null;
        });
    }
}
