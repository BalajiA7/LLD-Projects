package ParkingLot.services;

import ParkingLot.models.ParkingLot;

public interface IParkingLotService {
    public ParkingLot getParkingLotByGateId(int gateId);
}
