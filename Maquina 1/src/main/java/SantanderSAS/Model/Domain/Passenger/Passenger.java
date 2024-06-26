package SantanderSAS.Model.Domain.Passenger;



public class Passenger {
    private String name;
    private String lastName;
    private String[] phoneNumbers;
    private TypeIdentification typeIdentification;
    private String currentAddress;
    private String id;
    private ContactPerson contactPerson;


    public Passenger(){
        
    }

    public Passenger(String name, String lastName, String[] phoneNumbers, TypeIdentification typeIdentification,
                     String currentAddress, String id, ContactPerson contactPerson) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.typeIdentification = typeIdentification;
        this.currentAddress = currentAddress;
        this.id = id;
        this.contactPerson = contactPerson;
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

}
