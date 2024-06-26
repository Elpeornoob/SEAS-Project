package SantanderSAS.View.User;

import SantanderSAS.Controller.User.UserManager;
import SantanderSAS.Model.Domain.User;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class AddUserDialog extends JDialog {
    private final UserManager userManager;
    private final JTextField idField;
    private final JTextField usernameField;
    private final JTextField passwordField;
    private final JTextField nameField;
    private final JTextField lastNameField;
    private final JTextField phoneNumbersField;
    private final JTextField permitsField;

    public AddUserDialog(JFrame parent, UserManager userManager) {
        super(parent, "Add User", true);
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

        add(new JLabel("Permits:"));
        permitsField = new JTextField(); // Initialize permitsField
        add(permitsField);

        JButton addButton = new JButton("Add User");
        addButton.addActionListener(event -> {
            // Add user to the repository
            List<String> phoneNumbers = Arrays.asList(phoneNumbersField.getText().split(","));
            try {
                userManager.AddUser(new User(idField.getText(), usernameField.getText(), passwordField.getText(), nameField.getText(), lastNameField.getText(), phoneNumbers, permitsField.getText()));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            dispose();
        });
        add(addButton);

        pack();
        setLocationRelativeTo(parent);
    }
}