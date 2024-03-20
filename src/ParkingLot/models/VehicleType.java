package ParkingLot.models;

public enum VehicleType {
    BIKE,
    CAR,
    EV_CAR,
    TRUCK;

    public static VehicleType getTypeFromString(String type){
        for (VehicleType value : VehicleType.values()) {
            if (type.equals(value.toString())){
                return value;
            }
        }

        throw new IllegalArgumentException("unsupported vehicle Type");
    }

}
