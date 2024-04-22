package SantanderSAS.Controller.Route;

import SantanderSAS.Model.Domain.Graph.Graph;
import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Repository.RouteRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

public class RouteManager extends UnicastRemoteObject implements RouteManagerSkeleton{
    private RouteRepository routeRepository;
    private Graph graph;
    private static final long serialVersionUID = 123L;

    public RouteManager(RouteRepository repository) throws RemoteException{
        this.routeRepository = repository;
        this.graph = new Graph(routeRepository);
    }

    public void addRoute(Route route) {
        routeRepository.addRoute(route);
    }

    public void removeRoute(Route route) {
        routeRepository.removeRoute(route);
    }

    public void editRoute(Route oldRoute, Route newRoute) {
        routeRepository.editRoute(oldRoute, newRoute);
    }

    public List<Route> getRoutesFrom(String start) {
        return routeRepository.getRoutesFrom(start);
    }

    public Map<String, Integer> calculateShortestPaths(String start) {
        return graph.dijkstra(start);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.getAllRoutes();
    }
}