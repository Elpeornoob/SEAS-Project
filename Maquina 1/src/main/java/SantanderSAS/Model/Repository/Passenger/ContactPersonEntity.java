package SantanderSAS.Model.Repository.Passenger;

import java.io.Serializable;

public class ContactPersonEntity implements Serializable {
    private String name;
    private String lastName;
    private String[] phoneNumbers;

    public ContactPersonEntity(String name, String lastName, String[] phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }

}