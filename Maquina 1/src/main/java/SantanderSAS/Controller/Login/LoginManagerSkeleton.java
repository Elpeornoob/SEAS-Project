package SantanderSAS.Controller.Login;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginManagerSkeleton extends Remote {
    boolean login(String username, String password) throws RemoteException;
    String getPermits(String username) throws RemoteException;
}
