package LLD.ParkingLot.PaymentStrategy.ConcreteStrategy;

import LLD.ParkingLot.PaymentStrategy.PaymentStrategy;

public class CardStrategy implements PaymentStrategy {

    @Override
    public boolean processPayment(double payment) {
        System.out.println("Card Payment Successfully for amount " + payment);
        return true;
    }
}
