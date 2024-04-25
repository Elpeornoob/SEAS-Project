package SantanderSAS.View.Route;

import SantanderSAS.Controller.RouteManager;
import SantanderSAS.Model.Domain.Route;
import javax.swing.*;
import java.awt.*;

public class RemoveRouteDialog extends JDialog {
    private final JTextField startField;
    private final JTextField endField;
    private final JButton removeButton;

    public RemoveRouteDialog(JFrame parent, RouteManager routeManager) {
        super(parent, "Remove Route", true);

        startField = new JTextField();
        endField = new JTextField();
        removeButton = new JButton("Remove");

        removeButton.addActionListener(event -> {
            String start = startField.getText();
            String end = endField.getText();
            routeManager.removeRoute(new Route(start, end, 0));
            dispose();
        });

        setLayout(new GridLayout(3, 2));
        add(new JLabel("Start:"));
        add(startField);
        add(new JLabel("End:"));
        add(endField);
        add(removeButton);

        pack();
        setLocationRelativeTo(parent);
    }
}