package SantanderSAS.Model.Domain.Ticket;

import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.ContactPerson;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Passenger.Baggage.Baggage;

public class TicketStandard extends Ticket {

    public TicketStandard(String id, String dateHourbuy, String dateHourDeparture, String dateHourArrival, Route route,
            Passenger passenger, String ticketCategory, String idTrain, String place, String ticketCost,
            ContactPerson contactPerson, Baggage baggage, int seat) {
        super(id, dateHourbuy, dateHourDeparture, dateHourArrival, route, passenger, "Standard", idTrain, place, ticketCost,
                contactPerson, baggage, seat);
        //TODO Auto-generated constructor stub
    }
    
}
