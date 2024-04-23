import Model.TicketModel;
import Vista.TicketView;
import Controller.TicketController;
import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Passenger.ContactPerson;
import SantanderSAS.Model.Domain.Passenger.TypeIdentification;

public class TicketSGTTP {
    public static void main(String[] args) {
        // create a new ticket model
        String id = "someId";
        String dateHourbuy = "someDateHourbuy";
        String dateHourDeparture = "someDateHourDeparture";
        String dateHourArrival = "someDateHourArrival";

        // Create instances using constructors
        Route route = new Route("start", "end", 100);
        TypeIdentification typeIdentification = TypeIdentification.CEDULA_DE_CIUDADANIA; // Use enum constant directly
        ContactPerson contactPerson = new ContactPerson("name", "lastName", new String[]{"1234567890"});
        Passenger passenger = new Passenger("name", "lastName", new String[]{"1234567890"}, typeIdentification, "currentAddress", "somePassengerId", contactPerson);

        String ticketCategory = "someTicketCategory";
        String idTrain = "someIdTrain";
        String place = "somePlace";
        String ticketCost = "someTicketCost";
        int seat = 1;

        TicketModel model = new TicketModel(id, dateHourbuy, dateHourDeparture, dateHourArrival, route, passenger, ticketCategory, idTrain, place, ticketCost, contactPerson, seat);

        // create a view to get ticket details from user
        TicketView view = new TicketView();
        // create a controller
        TicketController controller = new TicketController(model, view);
    }
}