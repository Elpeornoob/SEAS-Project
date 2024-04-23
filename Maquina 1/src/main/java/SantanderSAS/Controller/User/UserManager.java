package SantanderSAS.Controller.User;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.User.UserRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class UserManager extends UnicastRemoteObject implements UserManagerSkeleton {
    private static final long serialVersionUID = 123L;
    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) throws RemoteException {
        super();
        this.userRepository = userRepository;
    }

    public void AddUser(User user) throws RemoteException {
        userRepository.addUser(user);
    }

    public void RemoveUser(String id) throws RemoteException {
        User user = userRepository.getUserById(id);
        if (user != null) {
            userRepository.removeUser(user);
        }
    }

    public void EditUser(User user) throws RemoteException {
        User existingUser = userRepository.getUserById(user.getID());
        if (existingUser != null) {
            userRepository.editUser(user);
        }
    }

    public Map<String, Object> getUser(String username) throws RemoteException {
    return userRepository.getUser(username);
}

    public Map<String, User> GetUsers() throws RemoteException {
        User[] users = userRepository.getUsers();
        Map<String, User> userMap = new HashMap<>();
        if (users != null) {
            for (User user : users) {
                userMap.put(user.getID(), user);
            }
        }
        return userMap;
    }
}