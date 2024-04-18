package SantanderSAS.Model.Domain.Wagon;

public class BaggageWagon extends Wagon {
    private int baggageCapacity;

    public BaggageWagon(String idWagon) {
        super(idWagon);
        baggageCapacity = 80;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }
    
}
