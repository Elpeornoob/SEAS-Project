package SantanderSAS.Model.Repository.User;

import java.io.Serializable;

public class UserEntity implements Serializable {
    String id;
    String username;
    String password;
    String name;
    String lastName;
    String phoneNumbers;
    String permits;

    public UserEntity(String id, String username, String password, String name, String lastName, String phoneNumbers, String permits) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.permits = permits;
    }
}