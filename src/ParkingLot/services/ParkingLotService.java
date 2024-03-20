package ParkingLot.services;

import ParkingLot.models.ParkingLot;
import ParkingLot.repositories.ParkingLotRepository;

public class ParkingLotService implements IParkingLotService{
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLot getParkingLotByGateId(int gateId) {
        return parkingLotRepository.getParkingLotByGateId(gateId);
    }
}
