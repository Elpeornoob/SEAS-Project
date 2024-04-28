package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.Ticket.Ticket;

public interface TicketValidatorSkeleton {
    
    boolean validateTicket(String id);

    Ticket getTicket(String id);

}
