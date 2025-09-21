package LLD.ParkingLot.ParkingSpots.ConcreteParkingSpots;

import LLD.ParkingLot.Constants.VehicleType;
import LLD.ParkingLot.ParkingSpots.ParkingSpots;
import LLD.ParkingLot.VehicleFactory.Vehicle;



public class BikeParkingSpot extends ParkingSpots {
    public BikeParkingSpot( int spotNo) {
        super(VehicleType.MOTORBIKE, spotNo);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals(VehicleType.MOTORBIKE);
    }
}
