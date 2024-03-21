package ParkingLot.services;

import ParkingLot.Exceptions.InvalidGateException;
import ParkingLot.Exceptions.InvalidTicketException;
import ParkingLot.factories.CalculateFeesStrategyFactory;
import ParkingLot.models.*;
import ParkingLot.repositories.InvoiceRepository;
import ParkingLot.strategies.pricing_strategy.CalculateFeeStrategy;

import java.util.*;

public class InvoiceService implements IInvoiceService{

    private final ITicketService ticketService;
    private final InvoiceRepository invoiceRepository;
    private final IGateService gateService;
    private final CalculateFeesStrategyFactory calculateFeesStrategyFactory;

    public InvoiceService(ITicketService ticketService, InvoiceRepository invoiceRepository, IGateService gateService, CalculateFeesStrategyFactory calculateFeesStrategyFactory) {
        this.ticketService = ticketService;
        this.invoiceRepository = invoiceRepository;
        this.gateService = gateService;
        this.calculateFeesStrategyFactory = calculateFeesStrategyFactory;
    }

    @Override
    public Invoice generateInvoice(int ticketId, int gateId) throws InvalidTicketException, InvalidGateException {
        /*
          1. Get Ticket From DB, If ticket object null it is an invalid throw exception
          2. Get Gate From DB, If gate object null or Gate is an Entry gate , it is an invalid throw exception
          3. Calculate charges via appropriate Strategies
          4. Create Invoice Object store in DB and return
         */

        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null){
            throw new InvalidTicketException("Ticket is not present in DB");
        }
        Gate gate = gateService.getGateById(gateId);
        if (gate == null){
            throw new InvalidGateException("Gate is not present in DB");
        }
        if(gate.getGateType().equals(GateType.ENTRY)){
            throw new InvalidGateException("Invoice can not be created at entry Gate");
        }

        Date entryDate = ticket.getEntry();
        Date exitDate = new Date();
        CalculateFeeStrategy calculateFeesStrategy = calculateFeesStrategyFactory.getCalculateFeesStrategy(exitDate);
        double totalAmount = calculateFeesStrategy.calculateFees(entryDate, exitDate, ticket.getVehicle().getVehicleType());

        InvoiceDetails invoiceDetails = new InvoiceDetails();
        invoiceDetails.setName("Parking Fees");
        invoiceDetails.setPrice(totalAmount);

        Invoice invoice = new Invoice();
        invoice.setDetails(Arrays.asList(invoiceDetails));
        invoice.setTicket(ticket);
        invoice.setExitTime(exitDate);

        return invoiceRepository.insertInvoice(invoice);
    }
}
