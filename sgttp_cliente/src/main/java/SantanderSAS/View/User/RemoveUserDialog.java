package SantanderSAS.View.User;

import javax.swing.*;

import SantanderSAS.Controller.User.UserManager;

import java.awt.*;
import java.rmi.RemoteException;

public class RemoveUserDialog extends JDialog {
    private final UserManager userManager;
    private final JTextField idField;

    public RemoveUserDialog(JFrame parent, UserManager userManager) {
        super(parent, "Remove User", true);
        this.userManager = userManager;

        setLayout(new GridLayout(2, 2));

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        JButton removeButton = new JButton("Remove User");
        removeButton.addActionListener(event -> {
            // Remove user from the repository
            try {
                userManager.RemoveUser(idField.getText());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            dispose();
        });
        add(removeButton);

        pack();
        setLocationRelativeTo(parent);
    }
}