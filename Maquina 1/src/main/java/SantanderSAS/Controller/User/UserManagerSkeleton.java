package SantanderSAS.Controller.User;

import SantanderSAS.Model.Domain.User;
import bryan.util.list.List;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface UserManagerSkeleton extends Remote {
    void AddUser(String ID, String username, String password, String name, String lastName, List<String> phoneNumbers, String permits) throws RemoteException;

    void RemoveUser(String id) throws RemoteException;

    void EditUser(User user) throws RemoteException;

    Map<String, Object> getUser(String username) throws RemoteException;

    Map<String, User> GetUsers() throws RemoteException;
}
