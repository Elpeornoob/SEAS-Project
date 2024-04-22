package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.UserRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginManager extends UnicastRemoteObject implements LoginManagerSkeleton {

    private static final long serialVersionUID = 123L;

    public LoginManager() throws RemoteException {
        super();
    }

    public boolean login(String username, String password) throws RemoteException {
        UserRepository userRepository = new UserRepository("C:\\Users\\Giank\\Desktop\\SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\user.json");
        User user = userRepository.getUser(username);
        if (user.equals(User.getNullUser())) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
