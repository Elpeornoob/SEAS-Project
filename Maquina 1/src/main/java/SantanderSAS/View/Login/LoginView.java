package SantanderSAS.View.Login;

import SantanderSAS.Controller.LoginManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private LoginManager loginManager;

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
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        // Here you can call another method or open another JFrame
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
            new LoginView(loginManager);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
