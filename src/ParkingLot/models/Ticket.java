package ParkingLot.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private Date entry;
    private Vehicle vehicle;
    private Spot spot;
    private Gate gate;

    /* to String */

    @Override
    public String toString() {
        return "Ticket{" +
                "entry=" + entry +
                ", " + vehicle.toString() +
                ", " + spot.toString() +
                ", " + gate.toString() +
                '}';
    }

    /* Getters and Setters */
    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
