package SantanderSAS.Controller.User;

import SantanderSAS.Model.Domain.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface UserManagerSkeleton extends Remote {
    void AddUser(User user) throws RemoteException;

    void RemoveUser(String id) throws RemoteException;

    void EditUser(User user) throws RemoteException;

    Map<String, Object> getUser(String username) throws RemoteException;

    Map<String, User> GetUsers() throws RemoteException;
}
