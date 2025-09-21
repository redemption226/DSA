package DesignPatterns.ObserverPattern.Subject;

import DesignPatterns.ObserverPattern.Observer.Observer;

public interface WeatherSubject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();
}
