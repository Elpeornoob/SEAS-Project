package SantanderSAS.Model.Domain.Wagon;

public class PeopleWagon extends Wagon {
    private final int allCapacityPeople;
    private final int premiunSeats;
    private final int executiveSeats;
    private final int standardSeats;

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
