package SantanderSAS.View.Train;

import SantanderSAS.Controller.Train.TrainManager;
import SantanderSAS.Model.Domain.Train.Train;
import SantanderSAS.Model.Repository.Train.TrainRepository;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.rmi.RemoteException;

public class TrainManagerView extends JFrame {
    private final JButton addButton;
    private final JButton removeButton;
    private final JButton editButton;
    private final TrainManager trainManager;
    private JTable trainTable;
    private JScrollPane scrollPane;

    public TrainManagerView(TrainManager trainManager) {
        this.trainManager = trainManager;

        setTitle("Train Manager");
        setSize(600, 600);
        setLayout(new BorderLayout());

        addButton = new JButton("Add Train");
        removeButton = new JButton("Remove Train");
        editButton = new JButton("Edit Train");

        addButton.addActionListener(event -> {
            new AddTrainDialog(this, trainManager).setVisible(true);
            updateTable();
        });

        removeButton.addActionListener(event -> {
            new RemoveTrainDialog(this, trainManager).setVisible(true);
            updateTable();
        });

        editButton.addActionListener(event -> {
            new EditTrainDialog(this, trainManager).setVisible(true);
            updateTable();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        add(buttonPanel, BorderLayout.WEST);

        trainTable = new JTable();
        scrollPane = new JScrollPane(trainTable);
        add(scrollPane, BorderLayout.CENTER);

        updateTable();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    private void updateTable() {
        Train[] trains = getTrains();
        remove(scrollPane);
        trainTable = new JTable(new TrainTableModel(trains));
        scrollPane = new JScrollPane(trainTable);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private Train[] getTrains() {
        try {
            return trainManager.getTrains();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Train[0];
        }
    }

    private static class TrainTableModel extends AbstractTableModel {
        private final Train[] trains;

        private static final String[] COLUMN_NAMES = {
                "Name", "Identifier", "Capacity", "Mileage", "Type"
        };

        public TrainTableModel(Train[] trains) {
            this.trains = trains;
        }

        @Override
        public int getRowCount() {
            return trains.length;
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Train train = trains[rowIndex];
            switch (columnIndex) {
                case 0:
                    return train.getNombre();
                case 1:
                    return train.getIdentificador();
                case 2:
                    return train.getCapacidadDeCarga();
                case 3:
                    return train.getKilometraje();
                case 4:
                    return train.getTipo();
                default:
                    return null;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrainRepository trainRepository = new TrainRepository("SEAS-Project\\Maquina 1\\src\\main\\java\\SantanderSAS\\Model\\DataBase\\train.json");
            TrainManager trainManager = null;
            try {
                trainManager = new TrainManager(trainRepository);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            TrainManagerView view = new TrainManagerView(trainManager);
            view.setVisible(true);
        });
    }
}