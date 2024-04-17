package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.UserRepository;

public class UserManager {
    private UserRepository userRepository;

    public UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.addUser(user);
    }

    public void removeUser(User user){
        userRepository.removeUser(user);
    }

    public void editUser(User user){
        userRepository.editUser(user);
    }

    public User getUser(String username){
        return userRepository.getUser(username);
    }

    public User[] getUsers(){
        return userRepository.getUsers();
    }
}