package ParkingLot.utills;

import java.util.Date;

public class DateTimeUtils {
    public static int calcHours(Date start, Date end){
        long timeDifference = end.getTime() - start.getTime();
        long diffInSec = timeDifference/1000;
        return (int) Math.ceil((double) diffInSec / 3600);
    }
}
