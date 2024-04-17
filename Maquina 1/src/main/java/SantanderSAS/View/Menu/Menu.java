package SantanderSAS.View.Menu;

import SantanderSAS.Controller.TrainManager;
import SantanderSAS.Model.Repository.TrainRepository;
import SantanderSAS.View.Train.TrainManagerView;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class Menu extends JFrame {
    private JButton routeManagerButton;
    private JButton trainManagerButton;
    private JButton userManagerButton;

    public Menu() {
        setTitle("Menu");
        setSize(300, 200);
        setLayout(new GridLayout(3, 1));

        routeManagerButton = new JButton("Route Manager");
        trainManagerButton = new JButton("Train Manager");
        userManagerButton = new JButton("User Manager");

        routeManagerButton.addActionListener(event -> {
            // Aquí debes instanciar y mostrar tu ventana RouteManager
            // Por ejemplo: new RouteManagerView().setVisible(true);
        });

        trainManagerButton.addActionListener(event -> {
        TrainRepository trainRepository = new TrainRepository("C:\\Users\\Giank\\Desktop\\SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\train.json");
        TrainManager trainManager = null;
        try {
            trainManager = new TrainManager(trainRepository);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        new TrainManagerView(trainManager).setVisible(true);
        });

        userManagerButton.addActionListener(event -> {
            // Aquí debes instanciar y mostrar tu ventana UserManager
            // Por ejemplo: new UserManagerView().setVisible(true);
        });

        add(routeManagerButton);
        add(trainManagerButton);
        add(userManagerButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}