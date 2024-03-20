package ParkingLot.services;

import ParkingLot.models.Gate;
import ParkingLot.repositories.GateRepository;

public class GateService implements IGateService{
    private final GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    @Override
    public Gate getGateById(int gateId){
        return gateRepository.getGateById(gateId);
    }
}
