package ParkingLot.services;

import ParkingLot.models.*;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.strategies.spot_assignment.AssignSpotStrategy;

import java.util.Date;

public class TicketService implements ITicketService {
    private final TicketRepository ticketRepository;
    private final IGateService gateService;
    private final IVehicleService vehicleService;
    private final IParkingLotService parkingLotService;
    private final AssignSpotStrategy assignSpotStrategy;

    public TicketService(TicketRepository ticketRepository, IGateService gateService, IVehicleService vehicleService, IParkingLotService parkingLotService, AssignSpotStrategy assignSpotStrategy) {
        this.ticketRepository = ticketRepository;
        this.gateService = gateService;
        this.vehicleService = vehicleService;
        this.parkingLotService = parkingLotService;
        this.assignSpotStrategy = assignSpotStrategy;
    }

    @Override
    public Ticket generateTicket(int gateId, String vehicleNumber, String vehicleType) throws Exception {
        /*
          1.Using Gate id, get the Gate Object
          2.Create If not Exist on the vehicle Object
          3.Using strategy pattern, figure out an empty spot or thrown an error
          4.Create a ticket object and store it in DB
         */

        Gate gate = gateService.getGateById(gateId);

        VehicleType type = VehicleType.getTypeFromString(vehicleType);
        Vehicle vehicle = vehicleService.createIfNotExists(vehicleNumber, type);

        ParkingLot parkingLot = parkingLotService.getParkingLotByGateId(gateId);
        if (parkingLot == null){
            throw new Exception("Invalid Gate Id");
        }
        Spot spot = assignSpotStrategy.assignSpot(type, parkingLot);

        Ticket ticket = new Ticket();
        ticket.setEntry(new Date());
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setSpot(spot);
        return this.insertTicket(ticket);
    }

    @Override
    public Ticket insertTicket(Ticket ticket) {
        return ticketRepository.insertTicket(ticket);
    }
}
