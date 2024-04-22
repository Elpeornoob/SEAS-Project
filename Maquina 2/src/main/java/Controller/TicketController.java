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

    // methods to update controller, set ticket data, update view etc.
}