package SantanderSAS.Model.Domain;

import java.util.List;

public class User {
    private String ID;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private List<String> phoneNumbers;
    private String Permits;

    public User(String ID, String username, String password, String name, String lastName, List<String> phoneNumbers, String permits) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        Permits = permits;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getPermits() {
        return Permits;
    }

    public void setPermits(String permits) {
        Permits = permits;
    }

    public static User getNullUser() {
        return new User(null, null, null, null, null, null, null);
    }
}
