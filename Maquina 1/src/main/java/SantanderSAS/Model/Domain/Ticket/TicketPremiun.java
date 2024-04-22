package SantanderSAS.Model.Domain.Ticket;

import SantanderSAS.Model.Domain.Passenger.Baggage.Baggage;
import SantanderSAS.Model.Domain.Passenger.ContactPerson;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Route;

public class TicketPremiun extends Ticket {

    public TicketPremiun(String id, String dateHourbuy, String dateHourDeparture, String dateHourArrival, Route route,
                         Passenger passenger, String ticketCategory, String idTrain, String place, String ticketCost,
                         ContactPerson contactPerson, Baggage baggage, int seat) {
        super(id, dateHourbuy, dateHourDeparture, dateHourArrival, route, passenger, "Premiun", idTrain, place, ticketCost,
                contactPerson, baggage, seat);
        //TODO Auto-generated constructor stub
    }


}
