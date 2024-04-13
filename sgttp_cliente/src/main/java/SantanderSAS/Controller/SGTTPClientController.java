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
        boolean op = true;
        do {
        Array<String> loginData = this.view.showLoginConsole();
        if (this.model.login(loginData.get(0), loginData.get(1))) {
            this.view.showMainConsole();
            op = false;
        } else {
            op = this.view.showLoginError();
        }
        } while (op);
    }
}
