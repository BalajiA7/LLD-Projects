package ParkingLot.services;

import ParkingLot.models.Vehicle;
import ParkingLot.models.VehicleType;

public interface IVehicleService {
    public Vehicle createIfNotExists(String vehicleNumber, VehicleType vehicleType);
}
