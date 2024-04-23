package SantanderSAS.View.User;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.rmi.RemoteException;

public class UserManagerView extends JFrame {
    private final JButton addButton;
    private final JButton removeButton;
    private final JButton editButton;
    private final UserManager userManager;
    private JTable userTable;
    private JScrollPane scrollPane;

    public UserManagerView(UserManager userManager) throws RemoteException {
        this.userManager = userManager;

        setTitle("User Manager");
        setSize(600, 600);
        setLayout(new BorderLayout());

        addButton = new JButton("Add User");
        removeButton = new JButton("Remove User");
        editButton = new JButton("Edit User");

        addButton.addActionListener(event -> {
            new AddUserDialog(this, userManager).setVisible(true);
            try {
                updateTable();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });

        removeButton.addActionListener(event -> {
            new RemoveUserDialog(this, userManager).setVisible(true);
            try {
                updateTable();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });

        editButton.addActionListener(event -> {
            new EditUserDialog(this, userManager).setVisible(true);
            try {
                updateTable();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
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

        updateTable();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void updateTable() throws RemoteException {
        User[] users = getUsers();
        remove(scrollPane);
        userTable = new JTable(new UserTableModel(users));
        scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private User[] getUsers() throws RemoteException {
        return userManager.GetUsers();
    }

    private static class UserTableModel extends AbstractTableModel {
        private final User[] users;

        private static final String[] COLUMN_NAMES = {
                "ID", "Username", "Password", "Name", "Last Name", "Phone Numbers", "Permits"
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
                    return user.getID();
                case 1:
                    return user.getUsername();
                case 2:
                    return user.getPassword();
                case 3:
                    return user.getName();
                case 4:
                    return user.getLastName();
                case 5:
                    return user.getPhoneNumbers();
                case 6:
                    return user.getpermits();
                default:
                    return null;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserRepository userRepository = new UserRepository("Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\user.json");
            UserManager userManager = null;
            try {
                userManager = new UserManager(userRepository);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            UserManagerView view = null;
            try {
                view = new UserManagerView(userManager);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            view.setVisible(true);
        });
    }
}