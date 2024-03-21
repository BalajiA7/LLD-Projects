package ParkingLot.services;

import ParkingLot.models.Slab;
import ParkingLot.models.VehicleType;
import ParkingLot.repositories.SlabRepository;
import ParkingLot.repositories.VehicleRepository;

import java.util.List;

public class SlabService implements ISlabService{
    private final SlabRepository slabRepository;

    public SlabService(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }

    @Override
    public List<Slab> getSlabsByVehicleType(VehicleType vehicleType) {
        return slabRepository.getSlabsByVehicleType(vehicleType);
    }
}
