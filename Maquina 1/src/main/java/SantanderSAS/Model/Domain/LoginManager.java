package SantanderSAS.Model.Domain;

import SantanderSAS.Model.Repository.UserRepository;

public class LoginManager {
    private UserRepository userRepository;

    public LoginManager(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password){
        User user = userRepository.getUser(username);
        if(user != User.getNullUser() && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
