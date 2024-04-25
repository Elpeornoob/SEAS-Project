package SantanderSAS.View.Route;

import SantanderSAS.Controller.RouteManager;
import SantanderSAS.Model.Domain.Route;
import javax.swing.*;
import java.awt.*;

public class EditRouteDialog extends JDialog {
    private final JTextField oldStartField;
    private final JTextField oldEndField;
    private final JTextField newStartField;
    private final JTextField newEndField;
    private final JTextField newDistanceField;
    private final JButton editButton;

    public EditRouteDialog(JFrame parent, RouteManager routeManager) {
        super(parent, "Edit Route", true);

        oldStartField = new JTextField();
        oldEndField = new JTextField();
        newStartField = new JTextField();
        newEndField = new JTextField();
        newDistanceField = new JTextField();
        editButton = new JButton("Edit");

        editButton.addActionListener(event -> {
            String oldStart = oldStartField.getText();
            String oldEnd = oldEndField.getText();
            String newStart = newStartField.getText();
            String newEnd = newEndField.getText();
            int newDistance = Integer.parseInt(newDistanceField.getText());
            routeManager.editRoute(new Route(oldStart, oldEnd, 0), new Route(newStart, newEnd, newDistance));
            dispose();
        });

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Old Start:"));
        add(oldStartField);
        add(new JLabel("Old End:"));
        add(oldEndField);
        add(new JLabel("New Start:"));
        add(newStartField);
        add(new JLabel("New End:"));
        add(newEndField);
        add(new JLabel("New Distance:"));
        add(newDistanceField);
        add(editButton);

        pack();
        setLocationRelativeTo(parent);
    }
}