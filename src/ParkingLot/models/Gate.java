package ParkingLot.models;

public class Gate extends BaseModel{
    private GateType gateType;
    private String name;
    private Operator operator;

    @Override
    public String toString(){
        return "Gate{" +
                "Gate Type=" + gateType +
                ", Gate Name=" + name +
                ", operator=" + operator +
                "}";
    }


    /* Getters and setters */
    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
