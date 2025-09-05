package ObserverPattern.Observer.ConcreteObserver;

import ObserverPattern.Observer.Observer;

public class MobileDisplay implements Observer {
    protected int temp;
    @Override
    public void update(int temp) {
        this.temp = temp;
        display();
    }

    public void display() {
        System.out.println("Temperature in Mobile is " + this.temp);
    }
}
