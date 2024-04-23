package SantanderSAS.Model.Domain;

import java.util.Objects;

public class Route {
    private String start;
    private String end;
    private int distance;
    private int nameRute;

    public Route(){
        
    }

    public Route(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    

    public Route(String start, String end, int distance, int nameRute) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.nameRute = nameRute;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return start.equals(route.start) && end.equals(route.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    public int getNameRute() {
        return nameRute;
    }

    public void setNameRute(int nameRuta) {
        this.nameRute = nameRuta;
    }

    
}
