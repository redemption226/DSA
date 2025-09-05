package ObserverPattern.Subject;

import ObserverPattern.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherSubject{

    List<Observer> observerList = new ArrayList<>();
    int temp;
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {

        for (Observer observer : observerList) {
            observer.update(temp);
        }

    }

    public void setData(int temp) {
        this.temp = temp;
        notifyObserver();
    }
}
