package SantanderSAS.Model.Domain.Ticket;

import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Route;

public class TicketPremiun extends Ticket {

    public TicketPremiun(String id, String dateHourbuy, String dateHourDeparture, String dateHourArrival, Route route,
                         Passenger passenger, String ticketCategory, String idTrain, String place, String ticketCost,
                         String seat) {
        super(id, dateHourbuy, dateHourDeparture, dateHourArrival, route, passenger, "Premiun", idTrain, place, seat);
        //TODO Auto-generated constructor stub
    }


}
