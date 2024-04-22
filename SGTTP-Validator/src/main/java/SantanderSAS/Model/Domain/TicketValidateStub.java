package SantanderSAS.Model.Domain;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicketValidateStub extends Remote{
    
    boolean verificarTicket(String id) throws RemoteException;

    String informacionTicket(String id) throws RemoteException;

}
