package SantanderSAS.View;

import javax.swing.*;
import java.awt.*;

import bryan.io.array.Array;

public class SGTTPClientView extends JFrame {
    private final JButton routeManagerButton;
    private final JButton trainManagerButton;
    private final JButton userManagerButton;

    public SGTTPClientView() {
        setTitle("Menu");
        setSize(300, 200);
        setLayout(new GridLayout(3, 1));

        routeManagerButton = new JButton("Route Manager");
        trainManagerButton = new JButton("Train Manager");
        userManagerButton = new JButton("User Manager");

        // Implement the logic for the action listeners here

        add(routeManagerButton);
        add(trainManagerButton);
        add(userManagerButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public Array<String> showLoginConsole() {
        // Implement the logic to show the login console and return the login data
        return null;
    }

    public boolean login(String username, String password) {
        // Implement the logic to perform the login and return whether it was successful
        return false;
    }

    public void showMainConsole() {
        // Implement the logic to show the main console
    }

    public boolean showLoginError(String loginResult) {
        // Implement the logic to show the login error and return whether to continue the login attempts
        return false;
    }
}