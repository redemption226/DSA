package ParkingLot.ParkingSpots;

import ParkingLot.Constants.VehicleType;
import ParkingLot.VehicleFactory.Vehicle;

public abstract class ParkingSpots {
    private boolean isOccupied;
    private VehicleType spotType;
    private int spotNo;
    private Vehicle vehicle;

    public ParkingSpots( VehicleType spotType, int spotNo) {
        this.isOccupied = false;
        this.spotNo = spotNo;
        this.spotType = spotType;
    }


    public abstract boolean canParkVehicle(Vehicle vehicle) ;

    public boolean parkVehicle(Vehicle vehicle) {
        if (isOccupied) {
            throw new IllegalStateException("Spot is already occupied.");
        }

        if (!canParkVehicle(vehicle)) {
            throw new IllegalStateException("Can't park vehicle." + vehicle.toString());
        }

        this.vehicle = vehicle;
        this.isOccupied = true;

        return true;
    }

    public boolean vacate () {
        if (!isOccupied())
            throw new IllegalStateException("Slot is already empty");

        this.vehicle = null;
        this.isOccupied = false;

        return true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public void setSpotType(VehicleType spotType) {
        this.spotType = spotType;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
