package SantanderSAS.Model.Repository;

import java.io.Serializable;

import SantanderSAS.Model.Domain.Passenger.Passenger;
import SantanderSAS.Model.Domain.Passenger.TypeIdentification;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonInterface;

public class PassengerRepository implements Serializable{
    
    private final FileJsonInterface<PassengerEntity> fileJson;
    private final String pathFile;

    public PassengerRepository(String pathFile) {
        this.fileJson = FileJsonAdapter.getInstance();
        this.pathFile = pathFile;
    }

    public Passenger getPassenger(String id){
        PassengerEntity[] passengerEntities = fileJson.getObjects(pathFile, PassengerEntity[].class);
        for(PassengerEntity passengerEntity: passengerEntities){
            if(passengerEntity.id.equals(id)){
                TypeIdentification typeIdentification = null;
                if(passengerEntity.typeIdentification.equals("CC")){
                    typeIdentification = TypeIdentification.CEDULA_DE_CIUDADANIA;
                }else if(passengerEntity.typeIdentification.equals("TI")){
                    typeIdentification = TypeIdentification.TARJETA_DE_IDENTIDAD;
                }else if(passengerEntity.typeIdentification.equals("CE")){
                    typeIdentification = TypeIdentification.CEDULA_DE_ESTRANJERIA;
                }else if(passengerEntity.typeIdentification.equals("RC")){
                    typeIdentification = TypeIdentification.REGISTRO_CIVIL;
                }else if(passengerEntity.typeIdentification.equals("CI")){
                    typeIdentification = TypeIdentification.CARNE_DE_IDENTIDAD;
                }
                return new Passenger(id, passengerEntity.name, passengerEntity.lastname, passengerEntity.phonenumber, typeIdentification, passengerEntity.currentaddress);
            }
        }
        return null;
    }

}
