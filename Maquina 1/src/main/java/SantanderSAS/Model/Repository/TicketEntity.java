package SantanderSAS.Model.Repository;

import java.io.Serializable;

public class TicketEntity implements Serializable{
     String id;
     String datehoutbuy;
     String datehourdeparture;
     String datehourarrival;
     String routestart;
     String routeend;
     String passenger;
     String ticketcategory;
     String idtrain;
     String place;
     String ticketcost;
     String baggageid;
     String seat;

    public TicketEntity(String id, String datehoutbuy, String datehourdeparture, String datehourarrival,
            String routestart, String routeend, String passenger, String ticketcategory, String idtrain, String place,
            String ticketcost, String baggageid, String seat) {
        this.id = id;
        this.datehoutbuy = datehoutbuy;
        this.datehourdeparture = datehourdeparture;
        this.datehourarrival = datehourarrival;
        this.routestart = routestart;
        this.routeend = routeend;
        this.passenger = passenger;
        this.ticketcategory = ticketcategory;
        this.idtrain = idtrain;
        this.place = place;
        this.ticketcost = ticketcost;
        this.baggageid = baggageid;
        this.seat = seat;
    }

}
