package ParkingLot.repositories;

import ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private final Map<Integer, Ticket> map;
    private static int id = 1;

    public TicketRepository(Map<Integer, Ticket> map){
        this.map = map;
    }

    public TicketRepository(){
        this.map = new HashMap<>();
    }

    public Ticket insertTicket(Ticket ticket){
       ticket.setId(id);
       map.put(id++, ticket);
       return ticket;
    }

    public void getTicket(){
        for(Map.Entry<Integer, Ticket> entry: map.entrySet()){
            Ticket ticket = entry.getValue();
            System.out.println(ticket);
        }
    }

    public Ticket getTicketById(int ticketId) {
        return map.get(ticketId);
    }
}
