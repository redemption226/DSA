package ObserverPattern;

import ObserverPattern.Observer.ConcreteObserver.MobileDisplay;
import ObserverPattern.Observer.ConcreteObserver.TVDisplay;
import ObserverPattern.Observer.Observer;
import ObserverPattern.Subject.WeatherStation;

import javax.security.auth.Subject;

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
