package SantanderSAS.Model.Repository;

import java.io.Serializable;

import SantanderSAS.Model.Domain.Ticket.Ticket;
import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonInterface;

public class TicketRepository implements Serializable{
    
    private final FileJsonInterface<TicketEntity> fileJson;
    private final String pathFile;

    public TicketRepository(String pathFile){
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean validateTicket(String id){
        try {
            TicketEntity[] tickets = fileJson.getObjects(pathFile, TicketEntity[].class);
            for(TicketEntity ticket : tickets){
                if(ticket.id.equals(id)){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
    }

    public Ticket getTicket(String id){
        try {
            TicketEntity[] tickets = fileJson.getObjects(pathFile, TicketEntity[].class);
            RouteRepository routeRepository = new RouteRepository("Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\route.json");
            PassengerRepository passengerRepository = new PassengerRepository("Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\passenger.json");
            for(TicketEntity ticket : tickets){
                if(ticket.id.equals(id)){
                    Route route =  routeRepository.getRoute(ticket.routestart, ticket.routeend);
                    Passenger passenger = passengerRepository.getPassenger(ticket.passenger);
                    return new Ticket(id, ticket.datehoutbuy, ticket.datehourdeparture, ticket.datehourarrival,route, passenger, 
                    ticket.ticketcategory, ticket.idtrain, ticket.place, ticket.ticketcost, ticket.passenger, Integer.parseInt(ticket.seat));
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
