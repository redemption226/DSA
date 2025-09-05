package ParkingLot.VehicleFactory.ConcreteVehicle;

import ParkingLot.Constants.VehicleType;
import ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import ParkingLot.VehicleFactory.Vehicle;

public class Bike extends Vehicle {

    public Bike(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        super(VehicleType.MOTORBIKE, licencePlate, parkingFeeStrategy);
    }
}
