package SantanderSAS.Model.Domain.Passenger.Baggage;

public class Baggage {
    private String baggageInfo;
    private String baggageId;
    private String weight;
    private String wagonId;
    
    public Baggage(String baggageInfo, String baggageId, String weight, String wagonId) {
        this.baggageInfo = baggageInfo;
        this.baggageId = baggageId;
        this.weight = weight;
        this.wagonId = wagonId;
    }

    public String getBaggageInfo() {
        return baggageInfo;
    }

    public void setBaggageInfo(String baggageInfo) {
        this.baggageInfo = baggageInfo;
    }

    public String getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(String baggageId) {
        this.baggageId = baggageId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWagonId() {
        return wagonId;
    }

    public void setWagonId(String wagonId) {
        this.wagonId = wagonId;
    }

    
}
