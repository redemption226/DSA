package LLD.BikeRental;

import LLD.BikeRental.Constants.ScooterEngineType;

public class Scooter implements Vehicle {

    ScooterEngineType scooterEngineType;
    boolean isRented;
    Scooter(ScooterEngineType scooterEngineType) {
        this.scooterEngineType = scooterEngineType;
    }

    @Override
    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    @Override
    public boolean getIsRented() {
        return this.isRented;
    }
}
