package SantanderSAS.View.User;

import SantanderSAS.Controller.User.UserManager;
import SantanderSAS.Model.Domain.User;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class EditUserDialog extends JDialog {
    private final UserManager userManager;
    private final JTextField idField;
    private final JTextField usernameField;
    private final JTextField passwordField;
    private final JTextField nameField;
    private final JTextField lastNameField;
    private final JTextField phoneNumbersField;
    private final JTextField permitsField;
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

        add(new JLabel("Permits:"));
        permitsField = new JTextField(); // Initialize permitsField
        add(permitsField);

        JButton editButton = new JButton("Edit User");
        editButton.addActionListener(event -> {
            // Edit user in the repository
            List<String> phoneNumbers = Arrays.asList(phoneNumbersField.getText().split(","));
            try {
                userManager.EditUser(new User(idField.getText(), usernameField.getText(), passwordField.getText(), nameField.getText(), lastNameField.getText(), phoneNumbers, permitsField.getText()));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            dispose();
        });
        add(editButton);

        pack();
        setLocationRelativeTo(parent);
    }
}