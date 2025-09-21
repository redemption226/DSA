package LLD.ParkingLot.VehicleFactory.ConcreteVehicle;

import LLD.ParkingLot.Constants.VehicleType;
import LLD.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import LLD.ParkingLot.VehicleFactory.Vehicle;

public class Car extends Vehicle {

    public Car(String licencePlate, ParkingFeeStrategy parkingFeeStrategy) {
        super(VehicleType.CAR, licencePlate, parkingFeeStrategy);
    }
}
