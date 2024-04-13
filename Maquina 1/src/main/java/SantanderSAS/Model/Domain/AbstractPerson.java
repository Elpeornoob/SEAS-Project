package SantanderSAS.Model.Domain;

import java.io.Serializable;
import bryan.array.Array;

public abstract class AbstractPerson implements Serializable {
    protected String name;
    protected String lastName;
    protected Array<String> phoneNumbers;
    protected String ID;

    public  AbstractPerson(){
        this.name = "N/A";
        this.lastName= "N/A";
        this.phoneNumbers = new Array<>(10);
    }
    public AbstractPerson(String name, String lastName, Array<String> phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = new Array<>(phoneNumbers);
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

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

}
