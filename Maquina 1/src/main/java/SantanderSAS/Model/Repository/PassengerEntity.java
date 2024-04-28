package SantanderSAS.Model.Repository;

import java.io.Serializable;

public class PassengerEntity implements Serializable{
    String id;
    String name;
    String lastname;
    String phonenumber;
    String typeIdentification;
    String currentaddress;

    public PassengerEntity(String id, String name, String lastname, String phonenumber, String typeIdentification,
            String currentaddress) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.typeIdentification = typeIdentification;
        this.currentaddress = currentaddress;
    }

    
}
