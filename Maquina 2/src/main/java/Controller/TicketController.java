package Controller;

import Model.TicketModel;
import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Passenger.ContactPerson;
import Vista.TicketView;


import java.io.FileWriter;
import java.io.IOException;

public class TicketController {
    private TicketModel model;
    private TicketView view;

    public TicketController(TicketModel model, TicketView view){
        this.model = model;
        this.view = view;
    }

    public void submitTicket() {
        String id = view.getId();
        model.setId(id);
    }

    public void purchaseTicket() {
        // Obtain the data from the model
        String id = model.getId();
        String dateHourbuy = model.getDateHourbuy();
        String dateHourDeparture = model.getDateHourDeparture();
        String dateHourArrival = model.getDateHourArrival();
        Route route = model.getRoute();
        Passenger passenger = model.getPassenger();
        String ticketCategory = model.getTicketCategory();
        String idTrain = model.getIdTrain();
        String place = model.getPlace();
        String ticketCost = model.getTicketCost();
        ContactPerson contactPerson = model.getContactPerson(); // Get the ContactPerson from the model
        int seat = model.getSeat();

        // Create a new TicketModel with the data
        TicketModel ticket = new TicketModel(id, dateHourbuy, dateHourDeparture, dateHourArrival, route, passenger, ticketCategory, idTrain, place, ticketCost, contactPerson, seat);

        // Save the ticket (this will depend on how you're handling data persistence)
        saveTicket();
    }

    private void saveTicket(){
        // Implementa la lógica para guardar el ticket aquí
        // Por ejemplo, podrías guardar el ticket en formato JSON en un archivo:
        try (FileWriter file = new FileWriter("tickets.json")) {
            file.write(model.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}