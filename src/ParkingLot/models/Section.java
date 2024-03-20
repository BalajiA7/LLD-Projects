package ParkingLot.models;

import java.util.List;

public class Section extends BaseModel{
    private String name;
    private List<Spot> spots;

    /* Getters and Setter */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }
}
