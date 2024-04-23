package SantanderSAS.Model;

import java.rmi.Naming;
import java.util.List;
import java.util.Map;

import SantanderSAS.Model.Domain.Train.Train;
import SantanderSAS.Model.Domain.User;
import sgttp_cliente.Model.Domain.LoginManagerStub;
import SantanderSAS.Controller.Route.RouteManagerStub;
import SantanderSAS.Model.Domain.Route;
import sgttp_cliente.Model.Domain.UserManagerStub;
import sgttp_cliente.Model.Domain.TrainManagerStub;

public class SGTTPClientModel {
    LoginManagerStub loginManager;
    UserManagerStub userManager;
    TrainManagerStub trainManager;
    RouteManagerStub routeManager;
    String url;

    public SGTTPClientModel(String ipService, String portServer, String serviceName) {
        this.url = "rmi://" + ipService + ":" + portServer + "/" + serviceName;
    }

    public String login(String username, String password) {
        try {
            this.loginManager = (LoginManagerStub) Naming.lookup(url);
            if (loginManager.login(username, password)) {
                User user = getUser(username);
                return user.getpermits();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    public void addTrain(Train train) {
        try {
            this.trainManager = (TrainManagerStub) Naming.lookup(url);
            trainManager.addTrain(train);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeTrain(String identificador) {
        try {
            this.trainManager = (TrainManagerStub) Naming.lookup(url);
            trainManager.removeTrain(identificador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTrain(Train train) {
        try {
            this.trainManager = (TrainManagerStub) Naming.lookup(url);
            trainManager.editTrain(train);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Train getTrain(String identificador) {
        try {
            this.trainManager = (TrainManagerStub) Naming.lookup(url);
            return trainManager.getTrain(identificador);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Train[] getTrains() {
        try {
            this.trainManager = (TrainManagerStub) Naming.lookup(url);
            return trainManager.getTrains();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addRoute(Route route) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            routeManager.addRoute(route);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeRoute(Route route) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            routeManager.removeRoute(route);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editRoute(Route oldRoute, Route newRoute) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            routeManager.editRoute(oldRoute, newRoute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Route> getRoutesFrom(String start) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            return routeManager.getRoutesFrom(start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Integer> calculateShortestPaths(String start) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            return routeManager.calculateShortestPaths(start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Route> getAllRoutes() {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            return routeManager.getAllRoutes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}