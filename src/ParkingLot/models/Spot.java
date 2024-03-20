package ParkingLot.models;

public class Spot extends BaseModel{
    private String name;
    private SpotStatus status;
    private VehicleType vehicleType;

    @Override
    public String toString() {
        return "Spot{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", vehicleType=" + vehicleType +
                " }";
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
