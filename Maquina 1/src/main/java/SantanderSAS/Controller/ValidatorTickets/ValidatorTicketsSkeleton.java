package SantanderSAS.Controller.ValidatorTickets;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ValidatorTicketsSkeleton extends Remote{
    
    boolean verificarTicket(String id) throws RemoteException;

    String informacionTicket(String id) throws RemoteException;

}
