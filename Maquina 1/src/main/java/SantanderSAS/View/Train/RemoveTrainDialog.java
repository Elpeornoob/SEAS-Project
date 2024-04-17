package SantanderSAS.View.Train;

import SantanderSAS.Controller.TrainManager;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;

public class RemoveTrainDialog extends JDialog {
    private JTextField identifierField;
    private JButton removeButton;

    public RemoveTrainDialog(Frame owner, TrainManager trainManager) {
        super(owner, "Remove Train", true);
        setLayout(new GridLayout(2, 2));

        identifierField = new JTextField();
        removeButton = new JButton("Remove");

        add(new JLabel("Identifier:"));
        add(identifierField);
        add(removeButton);

        removeButton.addActionListener(event -> {
            String identifier = identifierField.getText();

            try {
                trainManager.removeTrain(identifier);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            dispose();
        });

        pack();
        setLocationRelativeTo(owner);
    }
}