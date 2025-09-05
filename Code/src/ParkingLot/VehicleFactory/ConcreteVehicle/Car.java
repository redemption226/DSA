package ParkingLot.VehicleFactory.ConcreteVehicle;

import ParkingLot.Constants.VehicleType;
import ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import ParkingLot.VehicleFactory.Vehicle;

public class Car extends Vehicle {

    public Car(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        super(VehicleType.CAR, licencePlate, parkingFeeStrategy);
    }
}
