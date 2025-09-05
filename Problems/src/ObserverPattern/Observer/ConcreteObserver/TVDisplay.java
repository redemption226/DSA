package ObserverPattern.Observer.ConcreteObserver;

import ObserverPattern.Observer.Observer;

public class TVDisplay implements Observer {
    protected int temp;
    @Override
    public void update(int temp) {
        this.temp = temp;
        display();
    }

    public void display() {
        System.out.println("Temperature in TV is " + this.temp);
    }
}
