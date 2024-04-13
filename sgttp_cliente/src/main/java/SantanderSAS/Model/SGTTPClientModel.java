package SantanderSAS.Model;

import java.rmi.Naming;

import SantanderSAS.Model.Domain.LoginManagerStub;

public class SGTTPClientModel {
    LoginManagerStub loginManger;
    String url;

    public SGTTPClientModel(String ipService, String portServer, String serviceName){
        this.url = "rmi://" + ipService + ":" + portServer + "/" + serviceName;
    }

    public boolean login(String username, String password){
        try {
            this.loginManger = (LoginManagerStub) Naming.lookup(url);
            return loginManger.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
