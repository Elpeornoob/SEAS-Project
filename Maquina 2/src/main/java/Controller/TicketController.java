package Controller;

import Modelo.TicketModel;
import Vista.TicketView;

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

        // Add more code here to handle the rest of the attributes

        // Call your server here to handle the other files like Tren, Asiento, Ruta
    }
}