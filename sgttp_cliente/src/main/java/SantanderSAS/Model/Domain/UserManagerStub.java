package sgttp_cliente.Model.Domain;

import SantanderSAS.Model.Domain.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserManagerStub extends Remote {
    void AddUser(User user) throws RemoteException;

    void RemoveUser(String id) throws RemoteException;

    void EditUser(User user) throws RemoteException;

    User getUser(String username) throws RemoteException;

    User[] GetUsers() throws RemoteException;
}
