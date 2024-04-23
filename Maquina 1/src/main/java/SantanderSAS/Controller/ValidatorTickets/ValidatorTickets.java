package SantanderSAS.Controller.ValidatorTickets;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ValidatorTickets extends UnicastRemoteObject implements ValidatorTicketsSkeleton{

    private static final long serialVersionUID = 123L;

    protected ValidatorTickets() throws RemoteException {
        super();
        
    }

    public boolean verificarTicket(String id) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarTicket'");
    }

    public String informacionTicket(String id) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'informacionTicket'");
    }
    
}
