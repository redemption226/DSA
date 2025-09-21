package DesignPatterns.BuilderPattern;

public class Car {
    String model;
    String engine;
    Integer manufactureId;
    Double price;
    Integer year;



    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.engine = builder.engine;
        this.manufactureId = builder.manufactureId;
        this.price = builder.price;
        this.year = builder.year;
    }

    @Override
    public String toString() {
        return this.model + " " + this.engine + " " + this.manufactureId + " " + this.price + " " + this.year;
    }

    public static class CarBuilder {
        String model;
        String engine;
        Integer manufactureId;
        Double price;
        Integer year;

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setManufactureId(Integer manufactureId) {
            this.manufactureId = manufactureId;
            return this;
        }

        public CarBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public CarBuilder setYear(Integer year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

//        public CarBuilder(String model, String engine, Integer manufactureId, Double price, Integer year) {
//
//                if (model != null)
//        }

    }
}
