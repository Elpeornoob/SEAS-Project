package SantanderSAS.View.Train;

import SantanderSAS.Controller.Train.TrainManager;
import SantanderSAS.Model.Domain.Train.Train;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class EditTrainDialog extends JDialog {
    private final JTextField identifierField;
    private final JTextField nameField;
    private final JTextField capacityField;
    private final JTextField mileageField;
    private final JTextField typeField;
    private final JButton findButton;
    private final JButton editButton;

    public EditTrainDialog(Frame owner, TrainManager trainManager) {
        super(owner, "Edit Train", true);
        setLayout(new GridLayout(7, 2));

        identifierField = new JTextField();
        nameField = new JTextField();
        capacityField = new JTextField();
        mileageField = new JTextField();
        typeField = new JTextField();
        findButton = new JButton("Find");
        editButton = new JButton("Edit");

        add(new JLabel("Identifier:"));
        add(identifierField);
        add(findButton);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Capacity:"));
        add(capacityField);
        add(new JLabel("Mileage:"));
        add(mileageField);
        add(new JLabel("Type:"));
        add(typeField);
        add(editButton);

        findButton.addActionListener(event -> {
            String identifier = identifierField.getText();

            try {
                Train train = trainManager.getTrain(identifier);
                if (train != null) {
                    nameField.setText(train.getNombre());
                    capacityField.setText(String.valueOf(train.getCapacidadDeCarga()));
                    mileageField.setText(String.valueOf(train.getKilometraje()));
                    typeField.setText(train.getTipo());
                } else {
                    JOptionPane.showMessageDialog(this, "Train not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        editButton.addActionListener(event -> {
            String name = nameField.getText();
            String identifier = identifierField.getText();
            int capacity = Integer.parseInt(capacityField.getText());
            int mileage = Integer.parseInt(mileageField.getText());
            String type = typeField.getText();

            try {
                trainManager.editTrain(new Train(name, identifier, capacity, mileage, type));
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            dispose();
        });

        pack();
        setLocationRelativeTo(owner);
    }
}