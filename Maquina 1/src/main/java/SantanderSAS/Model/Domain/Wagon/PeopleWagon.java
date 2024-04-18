package SantanderSAS.Model.Domain.Wagon;

public class PeopleWagon extends Wagon {
    private int allCapacityPeople;
    private int premiunSeats;
    private int executiveSeats;
    private int standardSeats;

    public PeopleWagon(String idWagon) {
        super(idWagon);
        allCapacityPeople = 40;
        premiunSeats = 4;
        executiveSeats = 8;
        standardSeats = 28;
    }

    public int allgetCapacityPeople() {
        return allCapacityPeople;
    }

    public int getPremiunSeats() {
        return premiunSeats;
    }

    public int getExecutiveSeats() {
        return executiveSeats;
    }

    public int getStandardSeats() {
        return standardSeats;
    }

}
