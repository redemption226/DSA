package ParkingLot.ParkingSpots.ConcreteParkingSpots;

import ParkingLot.Constants.VehicleType;
import ParkingLot.ParkingSpots.ParkingSpots;
import ParkingLot.VehicleFactory.Vehicle;

public class CarParkingSpot extends ParkingSpots {
    public CarParkingSpot(int spotNo) {
        super(VehicleType.CAR, spotNo);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals(VehicleType.CAR);
    }
}
