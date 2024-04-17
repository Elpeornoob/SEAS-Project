package SantanderSAS.View.User;

import SantanderSAS.Controller.UserManager;
import SantanderSAS.Model.Domain.User;

import javax.swing.*;
import java.awt.*;

public class EditUserDialog extends JDialog {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton editButton;

    public EditUserDialog(Frame owner, UserManager userManager) {
        super(owner, "Edit User", true);
        setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JTextField();
        editButton = new JButton("Edit");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(editButton);

        editButton.addActionListener(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            User user = userManager.getUser(username);
            user.setPassword(password);

            userManager.editUser(user);

            dispose();
        });

        pack();
        setLocationRelativeTo(owner);
    }
}