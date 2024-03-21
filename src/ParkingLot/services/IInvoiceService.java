package ParkingLot.services;

import ParkingLot.Exceptions.InvalidGateException;
import ParkingLot.Exceptions.InvalidTicketException;
import ParkingLot.models.Invoice;

public interface IInvoiceService {
    public Invoice generateInvoice(int ticketId, int gateId) throws InvalidTicketException, InvalidGateException;
}
