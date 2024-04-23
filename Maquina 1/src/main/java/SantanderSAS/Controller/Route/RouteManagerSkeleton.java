package SantanderSAS.Controller.Route;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface RouteManagerSkeleton extends Remote {
    void addRoute(String start, String end, String distance, String nameRoute) throws RemoteException;

    void removeRoute(String nameRoute) throws RemoteException;

    void editRoute(String nameOldRoute, String start, String end, String distance, String nameRoute) throws RemoteException;

    List<Map<String , String>> getRoutesFrom(String start) throws RemoteException;

    Map<String, Integer> calculateShortestPaths(String start) throws RemoteException;

    List<Map<String, String>> getAllRoutes() throws RemoteException;

    List<Map<String, String>> getRouteByName(String nameRoute) throws RemoteException;
}