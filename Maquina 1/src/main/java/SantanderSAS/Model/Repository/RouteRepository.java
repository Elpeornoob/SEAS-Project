package SantanderSAS.Model.Repository;

import SantanderSAS.Model.Domain.Route;
import java.util.*;

public class RouteRepository {
    private Map<String, List<Route>> routes;

    public RouteRepository() {
        this.routes = new HashMap<>();
    }

    public void addRoute(Route route) {
        routes.putIfAbsent(route.getStart(), new ArrayList<>());
        routes.get(route.getStart()).add(route);
    }

    public void removeRoute(Route route) {
        List<Route> routeList = routes.get(route.getStart());
        if (routeList != null) {
            routeList.remove(route);
        }
    }

    public void editRoute(Route oldRoute, Route newRoute) {
        List<Route> routeList = routes.get(oldRoute.getStart());
        if (routeList != null) {
            int index = routeList.indexOf(oldRoute);
            if (index != -1) {
                routeList.set(index, newRoute);
            }
        }
    }

    public List<Route> getRoutesFrom(String start) {
        return routes.get(start);
    }

    public Map<String, List<Route>> getRoutes() {
        return routes;
    }
}