package ParkingLot.repositories;

import ParkingLot.models.Invoice;

import java.util.HashMap;
import java.util.Map;

public class InvoiceRepository {
    private Map<Integer, Invoice> map;
    private static int ID = 0;

    public InvoiceRepository(){
        this.map = new HashMap<>();
    }

    public InvoiceRepository(Map<Integer, Invoice> map){
        this.map = map;
    }

    public Invoice insertInvoice(Invoice invoice){
        invoice.setId(ID);
        map.put(ID++, invoice);
        return invoice;
    }

}
