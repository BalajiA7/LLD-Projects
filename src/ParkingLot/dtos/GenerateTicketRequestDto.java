package ParkingLot.dtos;

import ParkingLot.models.VehicleType;

public class GenerateTicketRequestDto {
    private int gateId;
    private String vehicleNumber;
    private String vehicleType;

    /* Getters and Setters */
    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
