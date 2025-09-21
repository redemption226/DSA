package LLD.ParkingLot.ParkingFeeStrategy;

import LLD.ParkingLot.Constants.VehicleType;

public interface ParkingFeeStrategy {

    double calculateFee(VehicleType vehicleType, int duration);
}
