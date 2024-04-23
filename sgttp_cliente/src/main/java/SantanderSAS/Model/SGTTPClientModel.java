package SantanderSAS.Model;

import java.rmi.Naming;
import java.util.List;
import java.util.Map;

import SantanderSAS.Model.Domain.RouteManagerStub;
import SantanderSAS.Model.Domain.LoginManagerStub;
import SantanderSAS.Model.Domain.UserManagerStub;
import SantanderSAS.Model.Domain.TrainManagerStub;



public class SGTTPClientModel {
    LoginManagerStub loginManager;
    UserManagerStub userManager;
    TrainManagerStub trainManager;
    RouteManagerStub routeManager;
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

    public void addUser(String id, String username, String password, String name, String lastName, String telefono) {
        try {
            this.userManager = (UserManagerStub) Naming.lookup(url);
            userManager.AddUser(id,username,password,name,lastName,telefono);
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

    public void editUser(String id) {
        try {
            this.userManager = (UserManagerStub) Naming.lookup(url);
            userManager.EditUser(id);
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

    public void addTrain(String name, String id, String capacidadDeCarga, String kilometraje, String tipo) {
        try {
            this.trainManager = (TrainManagerStub) Naming.lookup(url);
            trainManager.addTrain(name,id,capacidadDeCarga,kilometraje,tipo);
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

    public void editTrain(String train) {
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

    public void addRoute(String start, String end, String distance, String nameRoute) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            routeManager.addRoute(start, end, distance, nameRoute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeRoute(String nameRoute) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            routeManager.removeRoute(nameRoute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editRoute(String nameOldRoute, String start, String end, String distance, String nameRoute) {
        try {
            this.routeManager = (RouteManagerStub) Naming.lookup(url);
            routeManager.editRoute(nameRoute, start,end,distance,nameRoute);
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