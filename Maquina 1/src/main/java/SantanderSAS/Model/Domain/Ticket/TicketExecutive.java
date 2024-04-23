package SantanderSAS.Model.Domain.Ticket;

import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Route;

public class TicketExecutive extends Ticket {

    public TicketExecutive(String id, String dateHourbuy, String dateHourDeparture, String dateHourArrival, Route route,
                           Passenger passenger, String ticketCategory, String idTrain, String place, String ticketCost,
                           String seat) {
        super(id, dateHourbuy, dateHourDeparture, dateHourArrival, route, passenger, "Executive", idTrain, place, seat);
        //TODO Auto-generated constructor stub
    }

}
