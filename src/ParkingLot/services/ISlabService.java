package ParkingLot.services;

import ParkingLot.models.Slab;
import ParkingLot.models.VehicleType;

import java.util.List;

public interface ISlabService {
    public List<Slab> getSlabsByVehicleType(VehicleType vehicleType);
}
