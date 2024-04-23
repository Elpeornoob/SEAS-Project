package SantanderSAS.Controller.Route;

import SantanderSAS.Model.Domain.Graph.Graph;
import SantanderSAS.Model.Repository.Route.RouteRepository;
import SantanderSAS.Model.Domain.Route;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

public class RouteManager  implements RouteManagerSkeleton{
    private RouteRepository routeRepository;
    private Graph graph;
    private static final long serialVersionUID = 123L;

    public RouteManager(RouteRepository repository){
        this.routeRepository = repository;
        this.graph = new Graph(routeRepository);
    }

    public void addRoute(Route route) throws RemoteException {
        routeRepository.addRoute(route);
    }

    public void removeRoute(Route route) throws RemoteException {
        routeRepository.removeRoute(route);
    }

    public void editRoute(Route oldRoute, Route newRoute) throws RemoteException {
        routeRepository.editRoute(oldRoute, newRoute);
    }

    public List<Route> getRoutesFrom(String start) throws RemoteException {
        return routeRepository.getRoutesFrom(start);
    }

    public Map<String, Integer> calculateShortestPaths(String start) throws RemoteException {
        return graph.dijkstra(start);
    }

    public List<Route> getAllRoutes() throws RemoteException {
        return routeRepository.getAllRoutes();
    }
}