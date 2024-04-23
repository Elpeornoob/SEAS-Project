package SantanderSAS.Controller.User;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.User.UserRepository;
import bryan.util.list.List;

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

    public void AddUser(String ID, String username, String password, String name, String lastName, List<String> phoneNumbers, String permits) throws RemoteException {
        userRepository.addUser(new User(ID, username, password, name, lastName, null, permits));
    }

    public void RemoveUser(String id) throws RemoteException {
        User user = userRepository.getUserById(id);
        if (user != null) {
            userRepository.removeUser(user);
        }
    }

    public void EditUser(String id) throws RemoteException {
        User existingUser = userRepository.getUserById(id);
        if (existingUser != null) {
            userRepository.editUser(id);
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