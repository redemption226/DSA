package DesignPatterns.BuilderPattern;

public class CarController {
    public static void main(String[] args) {
        Car.CarBuilder builder = new Car.CarBuilder();

        Car car  = builder.setModel("Xing").setEngine("v8").setManufactureId(2012).
                setManufactureId(121).setPrice(9099876.0).setYear(2022).build();

        System.out.println(car);

    }
}
