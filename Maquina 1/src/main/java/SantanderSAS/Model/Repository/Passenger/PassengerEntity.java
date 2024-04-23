package SantanderSAS.Model.Repository.Passenger;

import java.io.Serializable;

public class PassengerEntity implements Serializable {
    private String name;
    private String lastName;
    private String[] phoneNumbers;
    private String typeIdentification;
    private String currentAddress;
    private String id;
    private ContactPersonEntity contactPerson;

    public PassengerEntity(String name, String lastName, String[] phoneNumbers, String typeIdentification,
                           String currentAddress, String id, ContactPersonEntity contactPerson) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.typeIdentification = typeIdentification;
        this.currentAddress = currentAddress;
        this.id = id;
        this.contactPerson = contactPerson;
    }
}