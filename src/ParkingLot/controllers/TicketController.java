package ParkingLot.controllers;

import ParkingLot.Exceptions.InvalidRequestException;
import ParkingLot.dtos.GenerateTicketRequestDto;
import ParkingLot.dtos.GenerateTicketResponseDto;
import ParkingLot.dtos.Response;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.models.Ticket;
import ParkingLot.services.ITicketService;

public class TicketController {

    private final ITicketService ticketService;

    public TicketController(ITicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        Response response = new Response();

        try {
            if (requestDto.getGateId() < 0){
                throw new InvalidRequestException("Invalid Gate Id");
            }
            if (requestDto.getVehicleType() == null || requestDto.getVehicleType().isEmpty()){
                throw new InvalidRequestException("Vehicle Type is mandatory");
            }
        }catch (InvalidRequestException e){
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
            responseDto.setResponse(response);
            return responseDto;
        }

        try {
            Ticket ticket = ticketService.generateTicket(requestDto.getGateId(), requestDto.getVehicleNumber(), requestDto.getVehicleType());
            responseDto.setTicket(ticket);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
        }

        responseDto.setResponse(response);
        return responseDto;
    }
}
