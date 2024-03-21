package ParkingLot.dtos;

public class GenerateInvoiceRequestDto {
    private int ticketId;
    private int gateId;

    /* Getters and Setters */
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }
}
