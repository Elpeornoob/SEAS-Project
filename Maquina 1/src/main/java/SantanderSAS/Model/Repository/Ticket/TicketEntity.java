package SantanderSAS.Model.Repository.Ticket;

import java.io.Serializable;

public class TicketEntity implements Serializable{
    String id;
    String datehourbuy;
    String datehourdeparture;
    String datehourarrival;
    String route;
    String idpassenger;
    String ticketcategory;
    String idtrain;
    String ticketcost;
    String seat;
    
    public TicketEntity(String id, String datehourbuy, String datehourdeparture, String datehourarrival, String route,
            String idpassenger, String ticketcategory, String idtrain, String ticketcost, String seat) {
        this.id = id;
        this.datehourbuy = datehourbuy;
        this.datehourdeparture = datehourdeparture;
        this.datehourarrival = datehourarrival;
        this.route = route;
        this.idpassenger = idpassenger;
        this.ticketcategory = ticketcategory;
        this.idtrain = idtrain;
        this.ticketcost = ticketcost;
        this.seat = seat;
    }

}
