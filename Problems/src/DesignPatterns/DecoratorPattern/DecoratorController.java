package DesignPatterns.DecoratorPattern;

import DesignPatterns.DecoratorPattern.Component.Coffee;
import DesignPatterns.DecoratorPattern.Component.ConcreteComponents.PlainCoffee;
import DesignPatterns.DecoratorPattern.Decorator.CoffeeDecorator;
import DesignPatterns.DecoratorPattern.Decorator.ConcreteDecorators.MilkDecorator;
import DesignPatterns.DecoratorPattern.Decorator.ConcreteDecorators.SugarDecorator;


/*Remember IS-A Has-A relationship for ABSTRACT decorators


 */


public class DecoratorController {
    public static void main(String[] args) {

        //Plain Coffee
        Coffee plainCoffee = new PlainCoffee();
        System.out.println(plainCoffee.printType());
        System.out.println(plainCoffee.getCost());

        //Milk Coffee
        CoffeeDecorator milkDecorator = new MilkDecorator(new PlainCoffee());
        System.out.println(milkDecorator.printType());
        System.out.println(milkDecorator.getCost());

        //Sugar Coffe with Milk
        CoffeeDecorator milkAndSugarCofee = new SugarDecorator(new MilkDecorator(new PlainCoffee()));
        System.out.println(milkAndSugarCofee.printType());
        System.out.println(milkAndSugarCofee.getCost());

    }
}
