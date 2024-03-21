package ParkingLot.strategies.pricing_strategy;

import ParkingLot.models.VehicleType;
import ParkingLot.utills.DateTimeUtils;

import java.util.Date;

public class WeekDayStrategy implements CalculateFeeStrategy{
    @Override
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType) {
        return DateTimeUtils.calcHours(entryTime, exitTime) * 10;
    }
}
