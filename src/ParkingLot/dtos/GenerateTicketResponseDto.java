package ParkingLot.dtos;

import ParkingLot.models.Ticket;

public class GenerateTicketResponseDto {
    private Ticket ticket;
    private Response response;

    /* Getters and Setters */
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
