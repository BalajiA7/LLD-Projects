package ParkingLot.factories;

import ParkingLot.repositories.SlabRepository;
import ParkingLot.services.ISlabService;
import ParkingLot.strategies.pricing_strategy.CalculateFeeStrategy;
import ParkingLot.strategies.pricing_strategy.WeekDayStrategy;
import ParkingLot.strategies.pricing_strategy.WeekEndStrategy;

import java.util.Calendar;
import java.util.Date;

public class CalculateFeesStrategyFactory {

    private final ISlabService slabService;

    public CalculateFeesStrategyFactory(ISlabService slabService) {
        this.slabService = slabService;
    }

    public CalculateFeeStrategy getCalculateFeesStrategy(Date exitDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(exitDate);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        boolean isWeekEnd = day == Calendar.SATURDAY || day == Calendar.SUNDAY;

        CalculateFeeStrategy calculateFeeStrategy;
        if(isWeekEnd){
            calculateFeeStrategy =  new WeekEndStrategy(slabService);
        }else{
            calculateFeeStrategy =  new WeekDayStrategy();
        }

        return calculateFeeStrategy;
    }
}
