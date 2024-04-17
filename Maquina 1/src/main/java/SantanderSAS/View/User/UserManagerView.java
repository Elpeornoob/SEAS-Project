package SantanderSAS.View.User;

import SantanderSAS.Controller.UserManager;
import SantanderSAS.Model.Domain.User;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class UserManagerView extends JFrame {
    private JButton addButton;
    private JButton removeButton;
    private JButton editButton;
    private UserManager userManager;
    private JTable userTable;
    private JScrollPane scrollPane;

    public UserManagerView(UserManager userManager) {
        this.userManager = userManager;

        setTitle("User Manager");
        setSize(600, 600);
        setLayout(new BorderLayout());

        addButton = new JButton("Add User");
        removeButton = new JButton("Remove User");
        editButton = new JButton("Edit User");

        addButton.addActionListener(event -> {
            new AddUserDialog(this, userManager).setVisible(true);
            updateUserTable();
        });

        removeButton.addActionListener(event -> {
            new RemoveUserDialog(this, userManager).setVisible(true);
            updateUserTable();
        });

        editButton.addActionListener(event -> {
            new EditUserDialog(this, userManager).setVisible(true);
            updateUserTable();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        add(buttonPanel, BorderLayout.WEST);

        userTable = new JTable();
        scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        updateUserTable();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void updateUserTable() {
        User[] users = getUsers();
        remove(scrollPane);
        userTable = new JTable(new UserTableModel(users));
        scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private User[] getUsers() {
        return userManager.getUsers();
    }

    private static class UserTableModel extends AbstractTableModel {
        private final User[] users;

        private static final String[] COLUMN_NAMES = {
                "Person ID", "Username", "Password" // Actualiza los nombres de las columnas
        };

        public UserTableModel(User[] users) {
            this.users = users;
        }

        @Override
        public int getRowCount() {
            return users.length;
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            User user = users[rowIndex];
            switch (columnIndex) {
                case 0:
                    return user.getPerson().toString();
                case 1:
                    return user.getUsername();
                case 2:
                    return user.getPassword();
                default:
                    return null;
            }
        }
    }
}