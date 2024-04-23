package SantanderSAS.Controller.Route;

import SantanderSAS.Model.Domain.Graph.Graph;
import SantanderSAS.Model.Repository.Route.RouteRepository;
import SantanderSAS.Model.Domain.Route;

import java.rmi.RemoteException;
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

    public void removeRoute(String routeName) throws RemoteException {
        List<Route> routesToRemove = routeRepository.getRoutesByName(routeName);
        for (Route route : routesToRemove) {
            routeRepository.removeRoute(route.getNameRute());
        }
    }

    public void editRoute(String oldRouteName, String start, String end, String distance, String newRouteName) throws RemoteException {
        List<Route> oldRoutes = routeRepository.getRoutesByName(oldRouteName);
        Route newRoute = new Route(start, end, Integer.parseInt(distance), newRouteName);
        for (Route oldRoute : oldRoutes) {
            routeRepository.editRoute(oldRoute.getNameRute(), start, end, distance, newRouteName);
        }
    }

    public List<Map<String, String>> getRoutesFrom(String start) throws RemoteException {
        return routeRepository.getRoutesFrom(start);
    }

    public Map<String, Integer> calculateShortestPaths(String start) throws RemoteException {
        return graph.dijkstra(start);
    }

    public List<Map<String, String>> getAllRoutes() throws RemoteException {
        return routeRepository.getAllRoutes();
    }

    public List<Route> getRouteByName(String nameRoute) throws RemoteException {
        return routeRepository.getRoutesByName(nameRoute);
    }
}