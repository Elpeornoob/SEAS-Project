package SantanderSAS.Model.Domain;

import java.io.Serializable;
import java.util.ArrayList;

import bryan.io.array.Array;

public abstract class AbstractPerson implements Serializable {
    protected String name;
    protected String lastName;
    protected ArrayList<String> phoneNumbers;

    public  AbstractPerson(){
        this.name = "N/A";
        this.lastName= "N/A";
        this.phoneNumbers = new Array<>(10);
    }
    public AbstractPerson(String name, String lastName, Array<String> phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = new Array(E[] e);
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

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}
