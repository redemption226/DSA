package ParkingLot.ParkingFeeStrategy.ConcreteStrategy;

import ParkingLot.Constants.VehicleType;
import ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;

public class HourlyFeeStartegy implements ParkingFeeStrategy {

    @Override
    public double calculateFee(VehicleType vehicleType, int duration) {
        if (vehicleType.equals(VehicleType.CAR)) {
            return 100;
        }
        else
            return 0;
    }
}
