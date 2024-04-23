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
    private final JTextField nameRuteField; // Nuevo campo
    private final JButton addButton;

    public AddRouteDialog(JFrame parent, RouteManager routeManager) {
        super(parent, "Add Route", true);

        startField = new JTextField();
        endField = new JTextField();
        distanceField = new JTextField();
        nameRuteField = new JTextField(); // Inicialización del nuevo campo
        addButton = new JButton("Add");

        addButton.addActionListener(event -> {
            String start = startField.getText();
            String end = endField.getText();
            int distance = Integer.parseInt(distanceField.getText());
            String nameRute = nameRuteField.getText(); // Obtener el valor del nuevo campo
            try {
                routeManager.addRoute(new Route(start, end, distance, nameRute)); // Pasar el nuevo valor
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            dispose();
        });

        setLayout(new GridLayout(5, 2)); // Actualizado a 5 para incluir el nuevo campo
        add(new JLabel("Start:"));
        add(startField);
        add(new JLabel("End:"));
        add(endField);
        add(new JLabel("Distance:"));
        add(distanceField);
        add(new JLabel("Name Route:")); // Etiqueta para el nuevo campo
        add(nameRuteField); // Agregar el nuevo campo al layout
        add(addButton);

        pack();
        setLocationRelativeTo(parent);
    }
}