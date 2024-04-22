package SantanderSAS.Model.Repository;

import bryan.array.Array;

import java.io.Serializable;

public class UserEntity implements Serializable {
    String id;
    String username;
    String password;
    String name;
    String lastName;
    Array<String> phoneNumbers;

    public UserEntity(String id, String username, String password, String name, String lastName, Array<String> phoneNumbers) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }
}