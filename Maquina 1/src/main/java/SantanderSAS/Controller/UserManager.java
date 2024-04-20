package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.UserRepository;

public class    UserManager {
    private UserRepository userRepository;

    public UserManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void AddUser(User user){
        userRepository.addUser(user);
    }

    public void RemoveUser(User user){
        userRepository.removeUser(user);
    }

    public void EditUser(User user){
        userRepository.editUser(user);
    }

    public User getUser(String username){
        return userRepository.getUser(username);
    }

    public User[] GetUsers(){
        return null;
    }
}
