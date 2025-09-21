package LLD.ParkingLot.ParkingSpots.ConcreteParkingSpots;

import LLD.ParkingLot.Constants.VehicleType;
import LLD.ParkingLot.ParkingSpots.ParkingSpots;
import LLD.ParkingLot.VehicleFactory.Vehicle;

public class CarParkingSpot extends ParkingSpots {
    public CarParkingSpot(int spotNo) {
        super(VehicleType.CAR, spotNo);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals(VehicleType.CAR);
    }
}
