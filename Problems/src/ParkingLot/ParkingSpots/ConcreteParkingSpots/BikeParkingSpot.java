package ParkingLot.ParkingSpots.ConcreteParkingSpots;

import ParkingLot.Constants.VehicleType;
import ParkingLot.ParkingSpots.ParkingSpots;
import ParkingLot.VehicleFactory.Vehicle;



public class BikeParkingSpot extends ParkingSpots {
    public BikeParkingSpot( int spotNo) {
        super(VehicleType.MOTORBIKE, spotNo);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals(VehicleType.MOTORBIKE);
    }
}
