package ObserverPattern.Subject;

import ObserverPattern.Observer.Observer;

public interface WeatherSubject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();
}
