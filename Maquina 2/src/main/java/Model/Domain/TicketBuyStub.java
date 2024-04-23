package Model.Domain;

import SantanderSAS.Model.Domain.Ticket.Ticket;

public class TicketBuyStub {
    private String expectedPassengerId;
    private String expectedRouteId;
    private Ticket expectedTicket;

    public TicketBuyStub(String expectedPassengerId, String expectedRouteId, Ticket expectedTicket) {
        this.expectedPassengerId = expectedPassengerId;
        this.expectedRouteId = expectedRouteId;
        this.expectedTicket = expectedTicket;
    }

    public Ticket buyTicket(String passengerId, String routeId) {
        if (passengerId.equals(expectedPassengerId) && routeId.equals(expectedRouteId)) {
            return expectedTicket;
        } else {
            return null;
        }
    }
}