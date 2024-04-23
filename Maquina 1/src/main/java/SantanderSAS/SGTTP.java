package SantanderSAS;

import SantanderSAS.Controller.SGTTPController;
import SantanderSAS.Controller.Login.LoginManager;
import SantanderSAS.Model.SGTTPModel;
import SantanderSAS.View.SGTTPView;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SGTTP {
    public static void main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("Maquina 1\\config.properties"))) {
            config.load(fin);
            SGTTPModel model = new SGTTPModel(
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICE_NAME"));
            SGTTPController controller = new SGTTPController(model, new SGTTPView("SGTTP Server", model.getMessenger()));
            controller.start();
        } catch (Exception e) {
            Logger.getLogger("AuthServer").log(Level.WARNING, e.getMessage(), e);
        }
    }
}