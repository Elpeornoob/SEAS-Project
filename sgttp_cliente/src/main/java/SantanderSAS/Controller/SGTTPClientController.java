package SantanderSAS.Controller;

import SantanderSAS.Model.SGTTPClientModel;
import SantanderSAS.View.SGTTPClientView;
import bryan.io.array.Array;

public class SGTTPClientController {
    private SGTTPClientModel model;
    private SGTTPClientView view;

    public SGTTPClientController(SGTTPClientModel model, SGTTPClientView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        String loginResult;
        do {
            Array<String> loginData = this.view.showLoginConsole();
            loginResult = this.model.login(loginData.get(0), loginData.get(1));
            if (loginResult.equals("success")) {
                this.view.showMainConsole();
                loginResult = null;
            } else {
                this.view.showLoginError(loginResult);
            }
        } while (loginResult != null);
    }
}
