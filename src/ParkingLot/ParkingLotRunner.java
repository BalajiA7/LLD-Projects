package ParkingLot;

import ParkingLot.controllers.TicketController;
import ParkingLot.dtos.GenerateTicketRequestDto;
import ParkingLot.dtos.GenerateTicketResponseDto;
import ParkingLot.dtos.Response;
import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.services.GateService;
import ParkingLot.services.ParkingLotService;
import ParkingLot.services.TicketService;
import ParkingLot.services.VehicleService;
import ParkingLot.strategies.spot_assignment.AssignSpotStrategy;
import ParkingLot.strategies.spot_assignment.NearestFirstSpotAssignmentStrategy;

import java.util.*;

public class ParkingLotRunner {
    public static void main(String[] args) {
        //Initialize Gates
        Gate gate1 =  new Gate();
        gate1.setName("1A");
        gate1.setGateType(GateType.ENTRY);
        gate1.setOperator(new Operator());
        gate1.setId(1);

        Gate gate2 =  new Gate();
        gate2.setName("2A");
        gate2.setGateType(GateType.EXIT);
        gate2.setOperator(new Operator());
        gate2.setId(2);

        Map<Integer, Gate> gateMap = new HashMap<>(){{
            put(1, gate1);
            put(2, gate2);
        }};

        //Initialize Spots
        Spot spot1 = new Spot();
        spot1.setId(1);
        spot1.setStatus(SpotStatus.UNOCCUPIED);
        spot1.setVehicleType(VehicleType.BIKE);
        Spot spot2 = new Spot();
        spot2.setId(2);
        spot2.setStatus(SpotStatus.UNOCCUPIED);
        spot2.setVehicleType(VehicleType.BIKE);
        Spot spot3 = new Spot();
        spot3.setId(3);
        spot3.setStatus(SpotStatus.UNOCCUPIED);
        spot3.setVehicleType(VehicleType.BIKE);
        List<Spot> spots1 = new ArrayList<>(Arrays.asList(spot1, spot2, spot3));

        Spot spot4 = new Spot();
        spot4.setId(4);
        spot4.setStatus(SpotStatus.UNOCCUPIED);
        spot4.setVehicleType(VehicleType.CAR);
        Spot spot5 = new Spot();
        spot5.setId(5);
        spot5.setStatus(SpotStatus.UNOCCUPIED);
        spot5.setVehicleType(VehicleType.CAR);
        Spot spot6 = new Spot();
        spot6.setId(6);
        spot6.setStatus(SpotStatus.UNOCCUPIED);
        spot6.setVehicleType(VehicleType.CAR);
        List<Spot> spots2 = new ArrayList<>(Arrays.asList(spot4, spot5, spot6));

        //Initialize Sections
        Section section1 = new Section();
        section1.setName("A");
        section1.setId(1);
        section1.setSpots(spots1);

        Section section2 = new Section();
        section2.setName("B");
        section2.setId(2);
        section2.setSpots(spots2);

        List<Section> sections = new ArrayList<>(Arrays.asList(section1, section2));

        //Initialize Floors
        Floor floor = new Floor();
        floor.setFloorNum(1);
        floor.setFloorStatus(FloorStatus.OPERATIONAL);
        floor.setSection(sections);

        //Initialize Parking Lot
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setId(1);
        parkingLot1.setFloors(List.of(floor));
        parkingLot1.setGates(List.of(gate1, gate2));

        Map<Integer, ParkingLot> parkingMap = new HashMap<>(){{
            put(1, parkingLot1);
        }};

        //Repositories (Data Bases)
        GateRepository gateRepository = new GateRepository(gateMap);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingMap);
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        //Services
        GateService gateService = new GateService(gateRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);

        //Strategies
        AssignSpotStrategy assignSpotStrategy = new NearestFirstSpotAssignmentStrategy();
        TicketService ticketService = new TicketService(ticketRepository, gateService, vehicleService, parkingLotService, assignSpotStrategy);

        //Controllers
        TicketController ticketController = new TicketController(ticketService);

        //Create Object of Generate Ticket request and call the  Generate Ticket Method
        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto();
        generateTicketRequestDto.setGateId(1);
        generateTicketRequestDto.setVehicleNumber("TN 39 CH 4741");
        generateTicketRequestDto.setVehicleType("BIKE");

        try{
            GenerateTicketResponseDto responseDto = ticketController.generateTicket(generateTicketRequestDto);
            Response response = responseDto.getResponse();
            System.out.println(response.getStatus());
            System.out.println(response.getError());
            ticketRepository.getTicket();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
