package SantanderSAS.Model.Repository.Passenger;

import java.io.Serializable;

public class PassengerEntity implements Serializable {

    String name;
    String lastName;
    String[] phoneNumbers;
    String typeIdentification;
    String currentAddres;
    String id;
    String namecp;
    String lastNamecp;
    String phoneNumberscp;
    
    public PassengerEntity(String name, String lastName, String[] phoneNumbers, String typeIdentification,
            String currentAddres, String id, String namecp, String lastNamecp, String phoneNumberscp) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.typeIdentification = typeIdentification;
        this.currentAddres = currentAddres;
        this.id = id;
        this.namecp = namecp;
        this.lastNamecp = lastNamecp;
        this.phoneNumberscp = phoneNumberscp;
    }

    
}
