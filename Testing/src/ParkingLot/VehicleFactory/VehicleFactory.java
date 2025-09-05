package ParkingLot.VehicleFactory;

import ParkingLot.Constants.VehicleType;
import ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import ParkingLot.VehicleFactory.ConcreteVehicle.Bike;
import ParkingLot.VehicleFactory.ConcreteVehicle.Car;

public class VehicleFactory {

    public Vehicle getVehicleType(VehicleType vehicleType, String licensePlateNo, ParkingFeeStrategy parkingFeeStrategy) {
        if (VehicleType.CAR.equals(vehicleType))
            return new Car(licensePlateNo, parkingFeeStrategy);
        else if (VehicleType.MOTORBIKE.equals(vehicleType))
            return new Bike(licensePlateNo, parkingFeeStrategy);
        else {
            return  null;

        }
    }
}
