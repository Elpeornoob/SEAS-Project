package SantanderSAS.View.User;

import SantanderSAS.Controller.UserManager;
import SantanderSAS.Model.Domain.User;

import javax.swing.*;
import java.awt.*;

public class AddUserDialog extends JDialog {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton addButton;

    public AddUserDialog(Frame owner, UserManager userManager) {
        super(owner, "Add User", true);
        setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JTextField();
        addButton = new JButton("Add");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(addButton);

        addButton.addActionListener(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            User user = userManager.getUser(username);
            user.setPassword(password);

            userManager.addUser(user);

            dispose();
        });

        pack();
        setLocationRelativeTo(owner);
    }
}