package SantanderSAS.Model.Repository.Route;

import SantanderSAS.Model.Domain.Graph.GraphWrapper;
import SantanderSAS.Model.Domain.Route;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RouteRepository implements Serializable{
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

    public void addRoute(String start, String end, String distance, String nameRoute) {
        Route route =  new Route(start, end, Integer.parseInt(distance), nameRoute);
        routes.putIfAbsent(route.getStart(), new ArrayList<>());
        routes.get(route.getStart()).add(route);
    }

    public void removeRoute(String nameRoute) {
        
    }

    public void editRoute(String nameOldRoute, String start, String end, String distance, String nameRoute) {
        
    }

    public List<Map<String, String>> getRoutesFrom(String start) {
        List<Route> rutas = routes.get(start);
        Iterator<Route> it = rutas.iterator();
        List<Map<String, String>> routeslist = new LinkedList<>();
        while (it.hasNext()) {
            Route route = it.next();
            Map<String, String> mapRoutes = new HashMap<String,String>();
            mapRoutes.put("start", route.getStart());
            mapRoutes.put("end", route.getEnd());
            mapRoutes.put("distance", String.valueOf(route.getDistance()));
            mapRoutes.put("nameroute", route.getNameRute());
            routeslist.add(mapRoutes);
        }
        return routeslist;
    }

    public List<Map<String, String>> getRoutes() {
        List<Map<String, String>> routesList = new LinkedList<>();
        for (List<Route> routeList : routes.values()) {
            for (Route route : routeList) {
                Map<String, String> mapRoutes = new HashMap<>();
                mapRoutes.put("start", route.getStart());
                mapRoutes.put("end", route.getEnd());
                mapRoutes.put("distance", String.valueOf(route.getDistance()));
                mapRoutes.put("nameroute", route.getNameRute());
                routesList.add(mapRoutes);
            }
        }
        return routesList;
    }

    public List<Map<String, String>> getAllRoutes() {
        List<Map<String, String>> allRoutes = new LinkedList<>();
        for (List<Route> routeList : routes.values()) {
            for (Route route : routeList) {
                Map<String, String> mapRoutes = new HashMap<>();
                mapRoutes.put("start", route.getStart());
                mapRoutes.put("end", route.getEnd());
                mapRoutes.put("distance", String.valueOf(route.getDistance()));
                mapRoutes.put("nameroute", route.getNameRute());
                allRoutes.add(mapRoutes);
            }
        }
        return allRoutes;
    }

    public List<Map<String, String>> getRoutesByName(String nameRoute) {
        List<Map<String, String>> matchingRoutes = new LinkedList<>();
        for (List<Route> routeList : routes.values()) {
            for (Route route : routeList) {
                if (String.valueOf(route.getNameRute()).equals(nameRoute)) {
                    Map<String, String> mapRoutes = new HashMap<>();
                    mapRoutes.put("start", route.getStart());
                    mapRoutes.put("end", route.getEnd());
                    mapRoutes.put("distance", String.valueOf(route.getDistance()));
                    mapRoutes.put("nameroute", route.getNameRute());
                    matchingRoutes.add(mapRoutes);
                }
            }
        }
        return matchingRoutes;
    }
}