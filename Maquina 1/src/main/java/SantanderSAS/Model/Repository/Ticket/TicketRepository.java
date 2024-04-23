package SantanderSAS.Model.Repository.Ticket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Ticket.Ticket;
import SantanderSAS.Model.Repository.Passenger.PassengerRepository;
import SantanderSAS.Model.Repository.Route.RouteRepository;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;

public class TicketRepository implements Serializable{

    private final FileJsonAdapter<TicketEntity> fileJson;
    private String pathFile;

    public TicketRepository(String pathFile){
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Map<String, Object> getTicket(String idTicket){
    TicketEntity[] ticketEntities = fileJson.getObjects(pathFile, TicketEntity[].class);
    RouteRepository routeRepository = new RouteRepository("Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\route.json");
    PassengerRepository passengerRepository = new PassengerRepository("Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\passenger.json");
    for(TicketEntity ticketEntity : ticketEntities){
        if(ticketEntity.id.equals(idTicket)){
            List<Map<String, String>> routes = routeRepository.getRoutesByName(ticketEntity.route);
            Map<String, Object> passengerMap = passengerRepository.getPassenger(ticketEntity.idpassenger);
            Map<String, Object> ticketMap = new HashMap<>();
            ticketMap.put("id", ticketEntity.id);
            ticketMap.put("datehourbuy", ticketEntity.datehourbuy);
            ticketMap.put("datehourdeparture", ticketEntity.datehourdeparture);
            ticketMap.put("datehourarrival", ticketEntity.datehourarrival);
            ticketMap.put("route", routes);
            ticketMap.put("passenger", passengerMap);
            ticketMap.put("ticketcategory", ticketEntity.ticketcategory);
            ticketMap.put("idtrain", ticketEntity.idtrain);
            ticketMap.put("ticketcost", ticketEntity.ticketcost);
            ticketMap.put("seat", ticketEntity.seat);
            return ticketMap;
        }
    }
    return null;
}
}