package SantanderSAS.Model.Repository;

import java.io.Serializable;

public class RouteEntity implements Serializable {
    String start;
    String end;
    int distance;

    public RouteEntity(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}