package LLD.ParkingLot;

import LLD.ParkingLot.Constants.VehicleType;
import LLD.ParkingLot.ParkingFeeStrategy.ConcreteStrategy.HourlyFeeStartegy;
import LLD.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import LLD.ParkingLot.ParkingLotController.ParkingLot;
import LLD.ParkingLot.ParkingSpots.ConcreteParkingSpots.BikeParkingSpot;
import LLD.ParkingLot.ParkingSpots.ConcreteParkingSpots.CarParkingSpot;
import LLD.ParkingLot.ParkingSpots.ParkingSpots;
import LLD.ParkingLot.PaymentStrategy.ConcreteStrategy.CardStrategy;
import LLD.ParkingLot.PaymentStrategy.Payment;
import LLD.ParkingLot.PaymentStrategy.PaymentStrategy;
import LLD.ParkingLot.VehicleFactory.Vehicle;
import LLD.ParkingLot.VehicleFactory.VehicleFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ParkingSpots> spots = new ArrayList<>();

        spots.add(new CarParkingSpot(1));
        spots.add(new CarParkingSpot(2));
        spots.add(new CarParkingSpot(3));
        spots.add( new BikeParkingSpot(4));
        spots.add(new BikeParkingSpot(5));
        spots.add(new BikeParkingSpot(6));


        ParkingLot parkingLot = ParkingLot.getInstance(spots);

        VehicleFactory vehicleFactory = new VehicleFactory();

        ParkingFeeStrategy parkingFeeStrategy = new HourlyFeeStartegy();

        Vehicle car1 = vehicleFactory.getVehicleType(VehicleType.CAR, "KA121", parkingFeeStrategy);
        Vehicle car2 = vehicleFactory.getVehicleType(VehicleType.CAR, "KA333", parkingFeeStrategy);

        Vehicle bike1 = vehicleFactory.getVehicleType(VehicleType.MOTORBIKE, "KA111", parkingFeeStrategy);

        Vehicle bike2 = vehicleFactory.getVehicleType(VehicleType.MOTORBIKE, "KA999", parkingFeeStrategy);


        ParkingSpots car1Spot =  parkingLot.parkVehicle(car1);
        if (car1Spot != null) {
            double amount = car1.calculateFee(20);
            PaymentStrategy paymentStrategy = new CardStrategy();
            Payment payment = new Payment(paymentStrategy);
            payment.processPayment(amount);
            parkingLot.vacateSpot(car1Spot,car1);
        }

        parkingLot.parkVehicle(car2);

        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);



    }
}
