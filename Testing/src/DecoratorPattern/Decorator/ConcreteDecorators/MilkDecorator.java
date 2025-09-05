package DecoratorPattern.Decorator.ConcreteDecorators;

import DecoratorPattern.Component.Coffee;
import DecoratorPattern.Decorator.CoffeeDecorator;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 3.0;
    }

    @Override
    public String printType() {
        return coffee.printType() + " + Milk";
    }

}
