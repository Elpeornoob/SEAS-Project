package SantanderSAS.Model.Domain;

import java.io.Serializable;

import bryan.io.array.Array;

@SuppressWarnings("unused")
public class Employee extends AbstractPerson implements Serializable {
    private String id;

    public Employee() {
        super();
        this.id = "";
    }

    public Employee(String name, String lastName, Array<String> phoneNumbers, String id) {
        super(name, lastName, phoneNumbers);
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Employee getNullEmployee(){
        return new Employee();
    }
}

