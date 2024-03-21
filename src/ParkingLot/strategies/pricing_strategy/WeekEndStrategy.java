package ParkingLot.strategies.pricing_strategy;

import ParkingLot.models.Slab;
import ParkingLot.models.VehicleType;
import ParkingLot.services.ISlabService;
import ParkingLot.utills.DateTimeUtils;

import java.util.Date;
import java.util.List;

public class WeekEndStrategy implements CalculateFeeStrategy{

    private final ISlabService slabService;

    public WeekEndStrategy(ISlabService slabService) {
        this.slabService = slabService;
    }

    @Override
    public double calculateFees(Date entryTime, Date exitTime, VehicleType vehicleType) {
        List<Slab> slabs = slabService.getSlabsByVehicleType(vehicleType);
        int hours = DateTimeUtils.calcHours(entryTime, exitTime);
        double totalAmount = 0;
        for (Slab slab: slabs){
            if (hours >= slab.getStartHour() && slab.getEndHour() != -1){
                if (hours >= slab.getEndHour()){
                    totalAmount += (slab.getEndHour() - slab.getStartHour()) * slab.getPricePerHour();
                }else {
                    totalAmount += (hours - slab.getStartHour()) * slab.getPricePerHour();
                }
            }else if(slab.getEndHour() == -1){
                totalAmount +=  (hours - slab.getStartHour()) * slab.getPricePerHour();
            }else{
                break;
            }
        }
        return totalAmount;
    }
}
