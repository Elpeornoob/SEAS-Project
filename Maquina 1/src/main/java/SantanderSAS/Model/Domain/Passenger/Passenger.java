package SantanderSAS.Model.Domain.Passenger;

import SantanderSAS.Model.Domain.Passenger.Baggage.Baggage;

public class Passenger {
    private String name;
    private String lastName;
    private String[] phoneNumbers;
    private TypeIdentification typeIdentification;
    private String currentAddress;
    private String id;
    private ContactPerson contactPerson;
    private Baggage baggage;

    public Passenger(){
        
    }

    public Passenger(String name, String lastName, String[] phoneNumbers, TypeIdentification typeIdentification,
                     String currentAddress, String id, ContactPerson contactPerson, Baggage baggage) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.typeIdentification = typeIdentification;
        this.currentAddress = currentAddress;
        this.id = id;
        this.contactPerson = contactPerson;
        this.baggage = baggage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public TypeIdentification getTypeIdentification() {
        return typeIdentification;
    }

    public void setTypeIdentification(TypeIdentification typeIdentification) {
        this.typeIdentification = typeIdentification;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }

}
