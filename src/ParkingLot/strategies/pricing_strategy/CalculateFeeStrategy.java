package ParkingLot.strategies.pricing_strategy;

import ParkingLot.models.VehicleType;

import java.util.Date;

public interface CalculateFeeStrategy {
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType);
}
