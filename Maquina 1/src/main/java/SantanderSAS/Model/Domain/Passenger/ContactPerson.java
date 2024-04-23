package SantanderSAS.Model.Domain.Passenger;

public class ContactPerson {
    private String name;
    private String lastName;
    private String[] phoneNumbers;
    
    public ContactPerson(String name, String lastName, String[] phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }

    public String getNaame() {
        return name;
    }

    public void setNaame(String naame) {
        this.name = naame;
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

    
}
