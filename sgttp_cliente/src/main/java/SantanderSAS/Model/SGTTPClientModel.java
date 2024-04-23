package SantanderSAS.Model;

import java.rmi.Naming;

import SantanderSAS.Model.Domain.LoginManagerStub;

public class SGTTPClientModel {
    LoginManagerStub loginManager;
    String url;

    public SGTTPClientModel(String ipService, String portServer, String serviceName) {
        this.url = "rmi://" + ipService + ":" + portServer + "/" + serviceName;
    }

    public boolean login(String username, String password) {
        try {
            this.loginManager = (LoginManagerStub) Naming.lookup(url);
            return loginManager.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addUser(User user) {
        try {
            this.userManager = (UserManagerStub) Naming.lookup(url);
            userManager.AddUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUser(String id) {
        try {
            this.userManager = (UserManagerStub) Naming.lookup(url);
            userManager.RemoveUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user) {
        try {
            this.userManager = (UserManagerStub) Naming.lookup(url);
            userManager.EditUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username) {
        try {
            this.userManager = (UserManagerStub) Naming.lookup(url);
            return userManager.getUser(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User[] getUsers() {
        try {
            this.userManager = (UserManagerStub) Naming.lookup(url);
            return userManager.GetUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
