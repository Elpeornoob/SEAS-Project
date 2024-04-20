package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.Route;
import SantanderSAS.Model.Domain.Graph.Graph;
import SantanderSAS.Model.Repository.RouteRepository;
import java.util.*;

public class RouteManager {
    private RouteRepository routeRepository;
    private Graph graph;

    public RouteManager(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
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