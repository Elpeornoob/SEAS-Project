package SantanderSAS;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import SantanderSAS.Controller.SGTTPClientController;
import SantanderSAS.Model.SGTTPClientModel;
import SantanderSAS.View.SGTTPClientView;

public class SGTTPClient {
    
    public static void main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("SEAS-Project/sgttp_cliente/config.properties"))) {
            config.load(fin);
            SGTTPClientModel model = new SGTTPClientModel(
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICE_NAME"));
            SGTTPClientController controller = new SGTTPClientController(model, new SGTTPClientView());
            controller.start();
        } catch (Exception e) {
            Logger.getLogger("AuthServer").log(Level.WARNING, e.getMessage(), e);
        }
    }
}
