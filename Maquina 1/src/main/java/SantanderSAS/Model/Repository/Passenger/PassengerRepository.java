package SantanderSAS.Model.Repository.Passenger;

import java.io.Serializable;

import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;

public class PassengerRepository  implements Serializable{
    
    private final FileJsonAdapter<Passenger> fileJson;
    private final String pathFile;

    public PassengerRepository(String pathFile){
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Passenger getPassenger(String idPassenger){
        Passenger[] passengers = fileJson.getObjects(pathFile, Passenger[].class);
        for (Passenger passenger : passengers) {
            if(passenger.getId().equals(idPassenger)){
                return passenger;
            }
        }
        return null;
    }
}
