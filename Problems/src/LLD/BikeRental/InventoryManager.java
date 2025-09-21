package LLD.BikeRental;

import LLD.BikeRental.Constants.BikeSize;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    List<Bike> bikes;
    List<Scooter> scooters;

    public int getBikes(BikeSize bikeSize) {
        int count =0;
        for (Bike bike : bikes) {
            if (bike.getBikeSize().equals(bikeSize)) {
                count++;
            }
        }
        return count;
    }

    public List<Vehicle> findAvailableVehicles(BikeSize bikeSize) {
        List<Vehicle> availableVehicels = new ArrayList<>();
        for (Bike bike : bikes) {
            if (!bike.getIsRented()) {
                availableVehicels.add(bike);
            }
        }

        for (Scooter scooter : scooters) {
            if (!scooter.getIsRented()) {
                availableVehicels.add(scooter);
            }
        }
        return availableVehicels;
    }
}
