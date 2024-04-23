package SantanderSAS.Controller.User;

import SantanderSAS.Model.Domain.User;
import SantanderSAS.Model.Repository.User.UserRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

    public User getUser(String username) throws RemoteException {
        return userRepository.getUser(username);
    }

    public User[] GetUsers() throws RemoteException {
        User[] users = userRepository.getUsers();
        return users != null ? users : new User[0];
    }


}