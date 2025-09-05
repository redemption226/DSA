package ParkingLot.VehicleFactory;

import ParkingLot.Constants.VehicleType;
import ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;

public abstract class Vehicle {

    protected VehicleType vehicleType;
    protected  String licensePlateNo;

    protected ParkingFeeStrategy parkingFeeStrategy;

    public Vehicle(VehicleType vehicleType, String licensePlateNo, ParkingFeeStrategy parkingFeeStrategy) {
        this.vehicleType = vehicleType;
        this.licensePlateNo = licensePlateNo;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public void setParkingFeeStrategy(ParkingFeeStrategy parkingFeeStrategy) {
        this.parkingFeeStrategy = parkingFeeStrategy;
    }



    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingFeeStrategy getParkingFeeStrategy() {
        return parkingFeeStrategy;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public double calculateFee(int duration) {

        return parkingFeeStrategy.calculateFee(vehicleType, duration);

    }


}
