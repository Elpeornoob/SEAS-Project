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

    public void removeUser(User user) {
        User[] users = fileJson.getObjects(pathFile, User[].class);
        User[] newUsers = new User[users.length - 1];
        int j = 0;
        for (User u : users) {
            if (!u.getUsername().equals(user.getUsername())) {
                newUsers[j++] = u;
            }
        }
        fileJson.writeObjects(pathFile, newUsers);
    }

    public void editUser(User user) {
        User[] users = fileJson.getObjects(pathFile, User[].class);
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(user.getUsername())) {
                users[i] = user;
            }
        }
        fileJson.writeObjects(pathFile, users);
    }

    public User[] getUsers() {
        return fileJson.getObjects(pathFile, User[].class);
    }
}