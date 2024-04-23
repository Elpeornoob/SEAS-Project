package SantanderSAS.Model.Repository.Passenger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;

public class PassengerRepository  implements Serializable{
    
    private final FileJsonAdapter<Passenger> fileJson;
    private final String pathFile;

    public PassengerRepository(String pathFile){
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Map<String, Object> getPassenger(String idPassenger){
        Passenger[] passengers = fileJson.getObjects(pathFile, Passenger[].class);
        for (Passenger passenger : passengers) {
            if(passenger.getId().equals(idPassenger)){
                Map<String, Object> passengerMap = new HashMap<>();
                passengerMap.put("id", passenger.getId());
                passengerMap.put("name", passenger.getName());
                // Add other passenger properties to the map
                return passengerMap;
            }
        }
        return null;
    }

}
