package ParkingLot.repositories;

import ParkingLot.models.Slab;
import ParkingLot.models.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlabRepository {

    private final Map<Integer, Slab> map;

    public SlabRepository(Map<Integer, Slab> map) {
        this.map = map;
    }

    public SlabRepository() {
        this.map = new HashMap<>();
    }

    public List<Slab> getSlabsByVehicleType(VehicleType vehicleType){
        List<Slab> slabs = new ArrayList<>();
        for (Map.Entry<Integer, Slab> entry : this.map.entrySet()) {
            Slab slab = entry.getValue();
            if (slab.getVehicleType().equals(vehicleType)) {
                slabs.add(slab);
            }
        }
//        slabs.sort((e1,e2) -> e1.getStartHour() - e2.getEndHour());
        return slabs;
    }

}
