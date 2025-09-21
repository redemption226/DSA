package LLD.BikeRental;

import LLD.BikeRental.Constants.BikeSize;

public class Bike implements Vehicle{

    BikeSize bikeSize;
    boolean isRented;

    Bike(BikeSize bikeSize) {
        this.bikeSize = bikeSize;
    }

    public BikeSize getBikeSize() {
        return this.bikeSize;
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
