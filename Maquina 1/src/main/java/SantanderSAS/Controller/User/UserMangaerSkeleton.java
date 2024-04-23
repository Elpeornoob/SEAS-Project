package SantanderSAS.Controller.User;

import SantanderSAS.Model.Domain.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserMangaerSkeleton extends Remote {
    void AddUser(User user) throws RemoteException;

    void RemoveUser(User user) throws RemoteException;

    void EditUser(User user) throws RemoteException;

    User getUser(String username) throws RemoteException;

    User[] GetUsers() throws RemoteException;
}
