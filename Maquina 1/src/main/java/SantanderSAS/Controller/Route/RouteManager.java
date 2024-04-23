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

    public void addRoute(String start, String end, String distance, String nameRoute) throws RemoteException {
        routeRepository.addRoute(start,end,distance,nameRoute);
    }

    public void removeRoute(String nameRoute) throws RemoteException {
        routeRepository.removeRoute(nameRoute);
    }

    public void editRoute(String nameOldRoute, String start, String end, String distance, String nameRoute) throws RemoteException {
        routeRepository.editRoute(nameOldRoute, start, end, distance, nameRoute);
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