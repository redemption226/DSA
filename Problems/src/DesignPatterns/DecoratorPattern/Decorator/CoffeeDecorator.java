package DesignPatterns.DecoratorPattern.Decorator;

import DesignPatterns.DecoratorPattern.Component.Coffee;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String printType() {
        return coffee.printType();
    }
}
