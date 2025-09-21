package DesignPatterns.DecoratorPattern.Component.ConcreteComponents;

import DesignPatterns.DecoratorPattern.Component.Coffee;

public class PlainCoffee implements Coffee {

    @Override
    public String printType() {
        return ("This is plain coffee");
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
