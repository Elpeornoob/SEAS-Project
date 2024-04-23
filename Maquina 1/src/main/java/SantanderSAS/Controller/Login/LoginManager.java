package SantanderSAS.Controller.Login;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.User.UserRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginManager extends UnicastRemoteObject implements LoginManagerSkeleton {

    private static final long serialVersionUID = 123L;
    private UserRepository userRepository;

    public LoginManager() throws RemoteException {
        super();
        userRepository = new UserRepository("C:\\Users\\Giank\\Desktop\\SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\user.json");
    }

    public boolean login(String username, String password) throws RemoteException {
        User user = userRepository.getUser(username);
        if (user.equals(User.getNullUser())) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    public String getPermits(String username) throws RemoteException {
        User user = userRepository.getUser(username);
        if (user.equals(User.getNullUser())) {
            return null;
        }
        return user.getpermits();
    }
}