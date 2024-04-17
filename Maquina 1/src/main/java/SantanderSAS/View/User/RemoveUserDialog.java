package SantanderSAS.View.User;

import SantanderSAS.Controller.UserManager;

import javax.swing.*;
import java.awt.*;

public class RemoveUserDialog extends JDialog {
    private JTextField usernameField;
    private JButton removeButton;

    public RemoveUserDialog(Frame owner, UserManager userManager) {
        super(owner, "Remove User", true);
        setLayout(new GridLayout(2, 2));

        usernameField = new JTextField();
        removeButton = new JButton("Remove");

        add(new JLabel("Username:"));
        add(usernameField);
        add(removeButton);

        removeButton.addActionListener(event -> {
            String username = usernameField.getText();

            userManager.removeUser(userManager.getUser(username));

            dispose();
        });

        pack();
        setLocationRelativeTo(owner);
    }
}
