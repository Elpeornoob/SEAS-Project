package SantanderSAS.Model.Repository;

import java.io.Serializable;
import SantanderSAS.Model.Domain.User;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonInterface;

public class UserRepository implements Serializable {

    private FileJsonInterface<User> fileJson;
    private String pathFile;

    public UserRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public User getUser(String username) {
        User[] users = fileJson.getObjects(pathFile, User[].class);
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // or return a default User
    }

    public void addUser(User user) {
        User[] users = fileJson.getObjects(pathFile, User[].class);
        User[] newUsers = new User[users.length + 1];
        System.arraycopy(users, 0, newUsers, 0, users.length);
        newUsers[newUsers.length - 1] = user;
        fileJson.writeObjects(pathFile, newUsers);
    }

    public User getUserById(String id) {
    User[] users = fileJson.getObjects(pathFile, User[].class);
    for (User user : users) {
        if (user.getID().equals(id)) {
            return user;
        }
    }
    return null; // or return a default User
    }

    public void removeUser(User user) {
    User[] users = fileJson.getObjects(pathFile, User[].class);
    int index = -1;
    for (int i = 0; i < users.length; i++) {
        if (users[i].getID().equals(user.getID())) {
            index = i;
            break;
        }
    }
    if (index != -1) {
        User[] newUsers = new User[users.length - 1];
        System.arraycopy(users, 0, newUsers, 0, index);
        System.arraycopy(users, index + 1, newUsers, index, users.length - index - 1);
        fileJson.writeObjects(pathFile, newUsers);
    } else {
        System.out.println("User not found: " + user.getID());
    }
}

    public void editUser(User user) {
    User[] users = fileJson.getObjects(pathFile, User[].class);
    for (int i = 0; i < users.length; i++) {
        if (users[i].getID().equals(user.getID())) {
            users[i] = user;
            break;
        }
    }
    fileJson.writeObjects(pathFile, users);
}

    public User[] getUsers() {
        return fileJson.getObjects(pathFile, User[].class);
    }
}