package SantanderSAS.Model.Repository.Ticket;

import java.io.Serializable;

import SantanderSAS.Model.Domain.Ticket.Ticket;
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
        RouteRepository routeRepository = new RouteRepository(idTicket);
        for(TicketEntity ticketEntity : ticketEntities){
            if(ticketEntity.id.equals(idTicket)){
                
                return new Ticket(ticketEntity.id, ticketEntity.datehourbuy, ticketEntity.datehourdeparture, ticketEntity.datehourarrival, null, null, idTicket, idTicket, idTicket, 0);
            }
        }
        return Ticket.getNullTicket();
    }
}
