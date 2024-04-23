package SantanderSAS.View.Route;

import SantanderSAS.Controller.Route.RouteManager;
import SantanderSAS.Model.Domain.Route;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class AddRouteDialog extends JDialog {
    private final JTextField startField;
    private final JTextField endField;
    private final JTextField distanceField;
    private final JButton addButton;

    public AddRouteDialog(JFrame parent, RouteManager routeManager) {
        super(parent, "Add Route", true);

        startField = new JTextField();
        endField = new JTextField();
        distanceField = new JTextField();
        addButton = new JButton("Add");

        addButton.addActionListener(event -> {
            String start = startField.getText();
            String end = endField.getText();
            int distance = Integer.parseInt(distanceField.getText());
            try {
                routeManager.addRoute(new Route(start, end, distance));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            dispose();
        });

        setLayout(new GridLayout(4, 2));
        add(new JLabel("Start:"));
        add(startField);
        add(new JLabel("End:"));
        add(endField);
        add(new JLabel("Distance:"));
        add(distanceField);
        add(addButton);

        pack();
        setLocationRelativeTo(parent);
    }
}