package ParkingLot.services;

import ParkingLot.models.Ticket;
import ParkingLot.models.VehicleType;

public interface ITicketService {
    public Ticket generateTicket(int gateId, String vehicleNumber, String vehicleType) throws Exception;
    public Ticket insertTicket(Ticket ticket);
    public Ticket getTicketById(int ticketId);
}
