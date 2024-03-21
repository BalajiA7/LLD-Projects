package ParkingLot.controllers;

import ParkingLot.Exceptions.InvalidRequestException;
import ParkingLot.dtos.GenerateInvoiceRequestDto;
import ParkingLot.dtos.GenerateInvoiceResponseDto;
import ParkingLot.dtos.Response;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.models.Invoice;
import ParkingLot.services.IInvoiceService;

public class InvoiceController {
    private final IInvoiceService invoiceService;

    public InvoiceController(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public GenerateInvoiceResponseDto generateInvoice(GenerateInvoiceRequestDto requestDto){
        GenerateInvoiceResponseDto responseDto = new GenerateInvoiceResponseDto();
        Response response = new Response();
        try{
            if (requestDto.getTicketId() < 0){
                throw new InvalidRequestException("Ticket id can't be negative");
            }
            if (requestDto.getGateId() < 0){
                throw new InvalidRequestException("Gate id can't be negative");
            }
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
            responseDto.setResponse(response);
            return  responseDto;
        }

        try {
            Invoice invoice = invoiceService.generateInvoice(requestDto.getTicketId(), requestDto.getGateId());
            response.setStatus(ResponseStatus.SUCCESS);
            responseDto.setInvoice(invoice);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
        }

        responseDto.setResponse(response);
        return responseDto;
    }
}
