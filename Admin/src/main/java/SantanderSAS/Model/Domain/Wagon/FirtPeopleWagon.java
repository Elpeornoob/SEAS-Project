package SantanderSAS.Model.Domain.Wagon;

public class FirtPeopleWagon extends Wagon {
    private final int allCapacityPeople;
    private final int premiunSeats;
    private final int executiveSeats;
    private final int standardSeats;

    public FirtPeopleWagon(String idWagon) {
        super(idWagon);
        allCapacityPeople = 34;
        premiunSeats = 4;
        executiveSeats = 8;
        standardSeats = 22;
    }

    public int getAllCapacityPeople() {
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
