package SantanderSAS.Controller.Route;

import SantanderSAS.Model.Domain.Route;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface RouteManagerSkeleton extends Remote {
    void addRoute(Route route) throws RemoteException;

    void removeRoute(Route route) throws RemoteException;

    void editRoute(Route oldRoute, Route newRoute) throws RemoteException;

    List<Route> getRoutesFrom(String start) throws RemoteException;

    Map<String, Integer> calculateShortestPaths(String start) throws RemoteException;

    List<Route> getAllRoutes() throws RemoteException;
}