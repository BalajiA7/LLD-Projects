package ParkingLot.models;

import java.util.Date;
import java.util.List;

public class Invoice extends BaseModel{

    private Ticket ticket;
    private Date exitTime;
    private double totalAmount;
    private List<InvoiceDetails> details;

    /* Getters and Setters */

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    private void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<InvoiceDetails> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetails> details) {
        this.details = details;
        for (InvoiceDetails invoiceDetails : details) {
            this.totalAmount += invoiceDetails.getPrice();
        }
    }
}
