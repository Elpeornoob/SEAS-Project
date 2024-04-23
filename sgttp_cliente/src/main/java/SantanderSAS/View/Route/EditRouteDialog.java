package SantanderSAS.View.Route;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class EditRouteDialog extends JDialog {
    private final JTextField oldStartField;
    private final JTextField oldEndField;
    private final JTextField newStartField;
    private final JTextField newEndField;
    private final JTextField newDistanceField;
    private final JTextField newNameRuteField; // Nuevo campo
    private final JButton editButton;

    public EditRouteDialog(JFrame parent, RouteManager routeManager) {
        super(parent, "Edit Route", true);

        oldStartField = new JTextField();
        oldEndField = new JTextField();
        newStartField = new JTextField();
        newEndField = new JTextField();
        newDistanceField = new JTextField();
        newNameRuteField = new JTextField(); // Inicialización del nuevo campo
        editButton = new JButton("Edit");

        editButton.addActionListener(event -> {
        String oldStart = oldStartField.getText();
        String oldEnd = oldEndField.getText();
        String newStart = newStartField.getText();
        String newEnd = newEndField.getText();
        int newDistance = Integer.parseInt(newDistanceField.getText());
        String newNameRute = newNameRuteField.getText(); // Obtener el valor del nuevo campo
        try {
            String oldRouteName = oldStart + "-" + oldEnd; // Create old route name
            routeManager.editRoute(oldRouteName, newStart, newEnd, String.valueOf(newDistance), newNameRute); // Pass the new values
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        dispose();
    });

        setLayout(new GridLayout(7, 2)); // Actualizado a 7 para incluir el nuevo campo
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
        add(new JLabel("New Name Route:")); // Etiqueta para el nuevo campo
        add(newNameRuteField); // Agregar el nuevo campo al layout
        add(editButton);

        pack();
        setLocationRelativeTo(parent);
    }
}