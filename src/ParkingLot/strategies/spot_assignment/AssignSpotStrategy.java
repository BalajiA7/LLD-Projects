package ParkingLot.strategies.spot_assignment;

import ParkingLot.Exceptions.NoSpotAvailableException;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.Spot;
import ParkingLot.models.VehicleType;

public interface AssignSpotStrategy {
    public Spot assignSpot(VehicleType vehicleType,ParkingLot parkingLot) throws NoSpotAvailableException;
}
