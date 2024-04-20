package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.UserRepository;

public class UserManager {
    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void AddUser(User user){
        userRepository.addUser(user);
    }

    // En UserManager.java
    public void RemoveUser(String id){
    User user = userRepository.getUserById(id);
    if (user != null) {
        userRepository.removeUser(user);
    }
}

    public void EditUser(User user){
    User existingUser = userRepository.getUserById(user.getID());
    if (existingUser != null) {
        userRepository.editUser(user);
    }
}

    public User getUser(String username){
        return userRepository.getUser(username);
    }

    public User[] GetUsers(){
        User[] users = userRepository.getUsers();
        return users != null ? users : new User[0];
    }
}