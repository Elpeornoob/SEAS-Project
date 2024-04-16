package SantanderSAS.Model;

import SantanderSAS.Model.Messenger.Messenger;
import SantanderSAS.Controller.LoginManagerSkeleton;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import SantanderSAS.Controller.LoginManager;

public class SGTTPModel {
    private String ip;
    private String port;
    private String serviceName;
    private String uri;
    private Messenger messenger;

    public SGTTPModel(String ip, String port, String serviceName) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        // "//192.168.0.1:1802/service"
        this.uri = "//" + this.ip + ":" + this.port + "/" + this.serviceName;
        this.messenger = new Messenger("Server Status: Stopped"); 
    }

    public boolean deploy() {
        try {
        System.setProperty("java.rmi.server.hostname", ip);
        LoginManagerSkeleton loginManagerService = new LoginManager();   
        LocateRegistry.createRegistry(Integer.parseInt(port));
        Naming.rebind(uri, loginManagerService);
        messenger.setMessage("Server Status: Running");
        return true;
        } catch (Exception e) {
        e.printStackTrace();
        }
        return false;
    }

    public Messenger getMessenger() {
        return messenger;
    }

}
