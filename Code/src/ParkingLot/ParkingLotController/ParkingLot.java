package ParkingLot.ParkingLotController;

import ParkingLot.ParkingSpots.ParkingSpots;
import ParkingLot.PaymentStrategy.Payment;
import ParkingLot.PaymentStrategy.PaymentStrategy;
import ParkingLot.VehicleFactory.Vehicle;

import java.util.List;

public class ParkingLot {

    private static ParkingLot parkingLot = null;

    private List<ParkingSpots> parkingSpotsList;

    private ParkingLot(List<ParkingSpots> parkings) {
        this.parkingSpotsList = parkings;
    }

    public static ParkingLot getInstance(List<ParkingSpots> parkings) {
        if (parkingLot == null) {
            synchronized (ParkingLot.class) {
                if (parkingLot == null)
                    parkingLot =  new ParkingLot(parkings);

            }

        }
            return parkingLot;
    }

    public ParkingSpots parkVehicle(Vehicle vehicle) {
        for (ParkingSpots parkingSpot : parkingSpotsList) {
            if (parkingSpot.getVehicle() == null && parkingSpot.getSpotType().equals(vehicle.getVehicleType())) {
                parkingSpot.parkVehicle(vehicle);
                return parkingSpot;
            }

        }
        return null;
    }

    public boolean vacateSpot(ParkingSpots spot, Vehicle vehicle) {

            if (spot != null && spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
                spot.vacate();
                System.out.println(vehicle.getVehicleType()
                        + " vacated the spot: " + spot.getSpotNo());
                return true;
            }
        System.out.println("Invalid operation! Either the spot is already vacant "
                + "or the vehicle does not match.");

        return false;
    }

}
