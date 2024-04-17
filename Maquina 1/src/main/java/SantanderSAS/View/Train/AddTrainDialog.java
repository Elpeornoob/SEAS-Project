package SantanderSAS.View.Train;

import SantanderSAS.Controller.TrainManager;
import SantanderSAS.Model.Domain.Train;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class AddTrainDialog extends JDialog {
    private JTextField nameField;
    private JTextField identifierField;
    private JTextField capacityField;
    private JTextField mileageField;
    private JTextField typeField;
    private JButton addButton;

    public AddTrainDialog(Frame owner, TrainManager trainManager) {
        super(owner, "Add Train", true);
        setLayout(new GridLayout(6, 2));

        nameField = new JTextField();
        identifierField = new JTextField();
        capacityField = new JTextField();
        mileageField = new JTextField();
        typeField = new JTextField();
        addButton = new JButton("Add");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Identifier:"));
        add(identifierField);
        add(new JLabel("Capacity:"));
        add(capacityField);
        add(new JLabel("Mileage:"));
        add(mileageField);
        add(new JLabel("Type:"));
        add(typeField);
        add(addButton);

        addButton.addActionListener(event -> {
            String name = nameField.getText();
            String identifier = identifierField.getText();
            int capacity = Integer.parseInt(capacityField.getText());
            int mileage = Integer.parseInt(mileageField.getText());
            String type = typeField.getText();

            try {
                trainManager.addTrain(new Train(name, identifier, capacity, mileage, type));
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            dispose();
        });

        pack();
        setLocationRelativeTo(owner);
    }
}