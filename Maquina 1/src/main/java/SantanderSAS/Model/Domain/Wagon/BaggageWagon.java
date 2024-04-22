package SantanderSAS.Model.Domain.Wagon;

public class BaggageWagon extends Wagon {
    private final int baggageCapacity;

    public BaggageWagon(String idWagon) {
        super(idWagon);
        baggageCapacity = 80;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }

}
