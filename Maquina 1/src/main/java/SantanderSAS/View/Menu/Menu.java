package SantanderSAS.View.Menu;

import SantanderSAS.Controller.RouteManager;
import SantanderSAS.Controller.TrainManager;
import SantanderSAS.Controller.UserManager;
import SantanderSAS.Model.Repository.RouteRepository;
import SantanderSAS.Model.Repository.TrainRepository;
import SantanderSAS.Model.Repository.UserRepository;
import SantanderSAS.View.Route.RouteManagerView;
import SantanderSAS.View.Train.TrainManagerView;
import SantanderSAS.View.User.UserManagerView;


import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class Menu extends JFrame {
    private final JButton routeManagerButton;
    private final JButton trainManagerButton;
    private final JButton userManagerButton;

    public Menu() {
        setTitle("Menu");
        setSize(300, 200);
        setLayout(new GridLayout(3, 1));

        routeManagerButton = new JButton("Route Manager");
        trainManagerButton = new JButton("Train Manager");
        userManagerButton = new JButton("User Manager");

        routeManagerButton.addActionListener(event -> {
        RouteRepository routeRepository = new RouteRepository("SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\route.json");
        RouteManager routeManager = new RouteManager(routeRepository);
            new RouteManagerView(routeManager).setVisible(true);
        });

        trainManagerButton.addActionListener(event -> {
        TrainRepository trainRepository = new TrainRepository("SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\train.json");
        TrainManager trainManager = null;
        try {
            trainManager = new TrainManager(trainRepository);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        new TrainManagerView(trainManager).setVisible(true);
        });

        userManagerButton.addActionListener(event -> {
        UserRepository userRepository = new UserRepository("SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\user.json");
        UserManager userManager = new UserManager(userRepository);
        new UserManagerView(userManager).setVisible(true);
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
