package DesignPatterns.DecoratorPattern.Decorator.ConcreteDecorators;

import DesignPatterns.DecoratorPattern.Component.Coffee;
import DesignPatterns.DecoratorPattern.Decorator.CoffeeDecorator;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }


    @Override
    public double getCost() {
        return coffee.getCost() + 1.5;
    }

    @Override
    public String printType() {
        return coffee.printType() + " + Sugar";
    }
}
