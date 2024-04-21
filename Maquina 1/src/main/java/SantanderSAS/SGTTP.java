package SantanderSAS;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import SantanderSAS.Controller.LoginManager;
import SantanderSAS.Controller.SGTTPController;
import SantanderSAS.Model.SGTTPModel;
import SantanderSAS.View.Login.LoginView;
import SantanderSAS.View.SGTTPView;

public class SGTTP {
    public static void main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("Maquina 1/config.properties"))) {
            config.load(fin);
            SGTTPModel model = new SGTTPModel(
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICE_NAME"));
            SGTTPController controller = new SGTTPController(model, new SGTTPView("SGTTP Server", model.getMessenger()));
            controller.start();

            // Start the login view
            LoginManager loginManager = new LoginManager();
            new LoginView(loginManager).setVisible(true);
        } catch (Exception e) {
            Logger.getLogger("AuthServer").log(Level.WARNING, e.getMessage(), e);
        }
    }
}