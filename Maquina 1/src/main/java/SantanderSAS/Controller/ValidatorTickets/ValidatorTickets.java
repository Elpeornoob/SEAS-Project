package SantanderSAS.Controller.ValidatorTickets;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ValidatorTickets extends UnicastRemoteObject implements ValidatorTicketsSkeleton{

    protected ValidatorTickets() throws RemoteException {
        super();
        
    }

    @Override
    public boolean verificarTicket(String id) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarTicket'");
    }

    @Override
    public String informacionTicket(String id) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'informacionTicket'");
    }
    
}
