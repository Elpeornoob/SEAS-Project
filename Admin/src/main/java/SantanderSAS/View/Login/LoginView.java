package SantanderSAS.View.Login;

import SantanderSAS.Controller.LoginManager;
import SantanderSAS.View.Menu.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class LoginView extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final LoginManager loginManager;

    public LoginView(LoginManager loginManager) {
        this.loginManager = loginManager;

        // Create UI components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean success = loginManager.login(usernameField.getText(), new String(passwordField.getPassword()));
                    if (success) {
                        // Show a success message
                        JOptionPane.showMessageDialog(null, "Login Exitoso.");
                        // Close the login window
                        dispose();
                        // Open the menu
                        new Menu().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
                    }
                } catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }
            }
        });

        // Add components to the frame
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            LoginManager loginManager = new LoginManager();
            new LoginView(loginManager).setVisible(true);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}