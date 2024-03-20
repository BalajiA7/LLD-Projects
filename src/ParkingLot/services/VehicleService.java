package ParkingLot.services;

import ParkingLot.models.Vehicle;
import ParkingLot.models.VehicleType;
import ParkingLot.repositories.VehicleRepository;

public class VehicleService implements IVehicleService{
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createIfNotExists(String vehicleNumber, VehicleType vehicleType) {
        return vehicleRepository.createIfNotExists(vehicleNumber, vehicleType);
    }
}
