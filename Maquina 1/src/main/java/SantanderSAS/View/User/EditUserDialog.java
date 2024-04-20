package SantanderSAS.View.User;

import SantanderSAS.Controller.UserManager;
import SantanderSAS.Model.Domain.User;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class EditUserDialog extends JDialog {
    private UserManager userManager;
    private JTextField idField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField phoneNumbersField;

    public EditUserDialog(JFrame parent, UserManager userManager) {
        super(parent, "Edit User", true);
        this.userManager = userManager;

        setLayout(new GridLayout(7, 2));

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JTextField();
        add(passwordField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Phone Numbers:"));
        phoneNumbersField = new JTextField();
        add(phoneNumbersField);

        JButton editButton = new JButton("Edit User");
        editButton.addActionListener(event -> {
            // Edit user in the repository
            List<String> phoneNumbers = Arrays.asList(phoneNumbersField.getText().split(","));
            userManager.EditUser(new User(idField.getText(), usernameField.getText(), passwordField.getText(), nameField.getText(), lastNameField.getText(), phoneNumbers));
            dispose();
        });
        add(editButton);

        pack();
        setLocationRelativeTo(parent);
    }
}