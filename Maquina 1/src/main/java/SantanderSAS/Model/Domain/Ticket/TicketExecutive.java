package SantanderSAS.Model.Domain.Ticket;

import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.ContactPerson;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Passenger.Baggage.Baggage;

public class TicketExecutive extends Ticket {

    public TicketExecutive(String id, String dateHourbuy, String dateHourDeparture, String dateHourArrival, Route route,
            Passenger passenger, String ticketCategory, String idTrain, String place, String ticketCost,
            ContactPerson contactPerson, Baggage baggage, int seat) {
        super(id, dateHourbuy, dateHourDeparture, dateHourArrival, route, passenger, "Executive", idTrain, place, ticketCost,
                contactPerson, baggage, seat);
        //TODO Auto-generated constructor stub
    }

}
