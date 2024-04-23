package SantanderSAS.Model.Domain;



import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserManagerStub extends Remote {
    void AddUser(String id, String username, String password, String name, String lastName, String phoneNumber) throws RemoteException;

    void RemoveUser(String id) throws RemoteException;

    void EditUser(String id) throws RemoteException;

    User getUser(String username);

    User[] GetUsers();
}
