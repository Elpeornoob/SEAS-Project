package SantanderSAS.Model.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractPerson implements Serializable {
    protected String name;
    protected String lastName;
    protected ArrayList<String> phoneNumbers;

    public  AbstractPerson(){
        this.name = "N/A";
        this.lastName= "N/A";
        this.phoneNumbers = new ArrayList<>(10);
    }
    public AbstractPerson(String name, String lastName, ArrayList<String> phoneNumbers) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
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
