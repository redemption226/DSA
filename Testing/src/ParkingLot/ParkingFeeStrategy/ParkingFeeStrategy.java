package ParkingLot.ParkingFeeStrategy;

import ParkingLot.Constants.VehicleType;

public interface ParkingFeeStrategy {

    double calculateFee(VehicleType vehicleType, int duration);
}
