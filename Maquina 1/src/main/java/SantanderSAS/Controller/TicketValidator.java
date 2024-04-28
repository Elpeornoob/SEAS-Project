package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.Ticket.Ticket;
import SantanderSAS.Model.Repository.TicketRepository;

public class TicketValidator implements TicketValidatorSkeleton{
    private TicketRepository ticketRepository;

    @Override
    public boolean validateTicket(String id) {
        return ticketRepository.validateTicket(id);
    }

    @Override
    public Ticket getTicket(String id) {
        return ticketRepository.getTicket(id);
    }
    
}
