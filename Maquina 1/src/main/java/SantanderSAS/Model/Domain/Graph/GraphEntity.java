package SantanderSAS.Model.Domain.Graph;

import SantanderSAS.Model.Domain.Route;

import java.util.List;
import java.util.Map;

public class GraphEntity {
    private Map<String, List<Route>> routes;

    public GraphEntity(Map<String, List<Route>> routes) {
        this.routes = routes;
    }

    public Map<String, List<Route>> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, List<Route>> routes) {
        this.routes = routes;
    }
}