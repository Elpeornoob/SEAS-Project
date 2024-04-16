package SantanderSAS.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginManagerSkeleton extends Remote{
    public boolean login(String username, String password) throws RemoteException;
}
