package LLD.ParkingLot.VehicleFactory.ConcreteVehicle;

import LLD.ParkingLot.Constants.VehicleType;
import LLD.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import LLD.ParkingLot.VehicleFactory.Vehicle;

public class Bike extends Vehicle {

    public Bike(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        super(VehicleType.MOTORBIKE, licencePlate, parkingFeeStrategy);
    }
}
