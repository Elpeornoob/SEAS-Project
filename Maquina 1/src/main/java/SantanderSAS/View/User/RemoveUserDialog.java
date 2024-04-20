package SantanderSAS.View.User;

import SantanderSAS.Controller.UserManager;

import javax.swing.*;
import java.awt.*;

public class RemoveUserDialog extends JDialog {
    private UserManager userManager;
    private JTextField idField;

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
            userManager.RemoveUser(idField.getText());
            dispose();
        });
        add(removeButton);

        pack();
        setLocationRelativeTo(parent);
    }
}