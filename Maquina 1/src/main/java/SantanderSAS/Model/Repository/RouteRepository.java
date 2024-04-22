package SantanderSAS.Model.Repository;

import SantanderSAS.Model.Domain.Graph.GraphWrapper;
import SantanderSAS.Model.Domain.Route;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteRepository {
    private Map<String, List<Route>> routes;
    private Gson gson;

    public RouteRepository(String filePath) {
        this.routes = new HashMap<>();
        this.gson = new Gson();
        try {
            GraphWrapper graphWrapper = gson.fromJson(new String(Files.readAllBytes(Paths.get(filePath))), GraphWrapper.class);
            if (graphWrapper != null && graphWrapper.getGraph() != null && graphWrapper.getGraph().getRoutes() != null) {
                this.routes = graphWrapper.getGraph().getRoutes();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read routes from file", e);
        }
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

    public List<Route> getAllRoutes() {
        List<Route> allRoutes = new ArrayList<>();
        for (List<Route> routeList : routes.values()) {
            allRoutes.addAll(routeList);
        }
        return allRoutes;
    }
}