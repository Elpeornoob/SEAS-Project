package SantanderSAS.Model.Domain;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface RouteManagerStub extends Remote {
    void addRoute(String start, String end, String distance, String nameRoute) throws RemoteException;

    void removeRoute(String nameRoute) throws RemoteException;

    void editRoute(String nameOldRoute, String start, String end, String distance, String nameRoute) throws RemoteException;

    Map<String, Integer> calculateShortestPaths(String start) throws RemoteException;

    List<Route> getRoutesFrom(String start) throws RemoteException;

    List<Route> getAllRoutes() throws RemoteException;
}