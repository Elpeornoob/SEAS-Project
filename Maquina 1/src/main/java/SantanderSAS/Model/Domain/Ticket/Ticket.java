package SantanderSAS.Model.Domain.Ticket;

import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.Passenger;

public class Ticket {
    private String id;
    private String dateHourbuy;
    private String dateHourDeparture;
    private String dateHourArrival;
    private Route route;
    private Passenger passenger;
    private String ticketCategory;
    private String idTrain;
    private String place;
    private String ticketCost;
    private String baggage;
    private int seat;

    public Ticket(String id, String dateHourbuy, String dateHourDeparture, String dateHourArrival, Route route,
            Passenger passenger, String ticketCategory, String idTrain, String place, String ticketCost,
            String baggage, int seat) {
        this.id = id;
        this.dateHourbuy = dateHourbuy;
        this.dateHourDeparture = dateHourDeparture;
        this.dateHourArrival = dateHourArrival;
        this.route = route;
        this.passenger = passenger;
        this.ticketCategory = ticketCategory;
        this.idTrain = idTrain;
        this.place = place;
        this.ticketCost = ticketCost;
        this.baggage = baggage;
        this.seat = seat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateHourbuy() {
        return dateHourbuy;
    }

    public void setDateHourbuy(String dateHourbuy) {
        this.dateHourbuy = dateHourbuy;
    }

    public String getDateHourDeparture() {
        return dateHourDeparture;
    }

    public void setDateHourDeparture(String dateHourDeparture) {
        this.dateHourDeparture = dateHourDeparture;
    }

    public String getDateHourArrival() {
        return dateHourArrival;
    }

    public void setDateHourArrival(String dateHourArrival) {
        this.dateHourArrival = dateHourArrival;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
    
}
