package DesignPatterns.ObserverPattern;

import DesignPatterns.ObserverPattern.Observer.ConcreteObserver.MobileDisplay;
import DesignPatterns.ObserverPattern.Observer.ConcreteObserver.TVDisplay;
import DesignPatterns.ObserverPattern.Observer.Observer;
import DesignPatterns.ObserverPattern.Subject.WeatherStation;

public class WeatherController {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer tvObserver = new TVDisplay();
        Observer mobObserver = new MobileDisplay();

        weatherStation.addObserver(tvObserver);
        weatherStation.addObserver(mobObserver);

        weatherStation.setData(20);

        weatherStation.deleteObserver(mobObserver);

        weatherStation.setData(30);


    }
}
