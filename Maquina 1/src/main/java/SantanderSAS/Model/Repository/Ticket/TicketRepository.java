package SantanderSAS.Model.Repository.Ticket;

import java.io.Serializable;

import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Ticket.Ticket;
import SantanderSAS.Model.Repository.Passenger.PassengerRepository;
import SantanderSAS.Model.Repository.Route.RouteRepository;
import SantanderSAS.Model.Repository.User.UserEntity;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;

public class TicketRepository implements Serializable{
    
    private final FileJsonAdapter<TicketEntity> fileJson;
    private String pathFile;

    public TicketRepository(String pathFile){
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Ticket getTicket(String idTicket){
        TicketEntity[] ticketEntities = fileJson.getObjects(idTicket, TicketEntity[].class);
        RouteRepository routeRepository = new RouteRepository("Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\ticket.json");
        PassengerRepository passengerRepository = new PassengerRepository("Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\passenger.json");
        for(TicketEntity ticketEntity : ticketEntities){
            if(ticketEntity.id.equals(idTicket)){
                Route route = routeRepository.getRouteByName(ticketEntity.route);
                Passenger passenger = passengerRepository.getPassenger(ticketEntity.idpassenger);
                return new Ticket(ticketEntity.id, ticketEntity.datehourbuy, ticketEntity.datehourdeparture, ticketEntity.datehourarrival, route, passenger, idTicket, idTicket, idTicket, 0);
            }
        }
        return Ticket.getNullTicket();
    }
}
