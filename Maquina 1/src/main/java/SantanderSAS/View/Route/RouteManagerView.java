package SantanderSAS.View.Route;

import SantanderSAS.Controller.RouteManager;
import SantanderSAS.Model.Domain.Route;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class RouteManagerView extends JFrame {
    private final JButton addButton;
    private final JButton removeButton;
    private final JButton editButton;
    private final RouteManager routeManager;
    private JTable routeTable;
    private JScrollPane scrollPane;

    public RouteManagerView(RouteManager routeManager) {
        this.routeManager = routeManager;

        setTitle("Route Manager");
        setSize(600, 600);
        setLayout(new BorderLayout());

        addButton = new JButton("Add Route");
        removeButton = new JButton("Remove Route");
        editButton = new JButton("Edit Route");

        addButton.addActionListener(event -> {
            new AddRouteDialog(this, routeManager).setVisible(true);
            updateTable();
        });

        removeButton.addActionListener(event -> {
            new RemoveRouteDialog(this, routeManager).setVisible(true);
            updateTable();
        });

        editButton.addActionListener(event -> {
            new EditRouteDialog(this, routeManager).setVisible(true);
            updateTable();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        add(buttonPanel, BorderLayout.WEST);

        routeTable = new JTable();
        scrollPane = new JScrollPane(routeTable);
        add(scrollPane, BorderLayout.CENTER);

        updateTable();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void updateTable() {
        Route[] routes = getRoutes();
        remove(scrollPane);
        routeTable = new JTable(new RouteTableModel(routes));
        scrollPane = new JScrollPane(routeTable);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private Route[] getRoutes() {
        return routeManager.getAllRoutes().toArray(new Route[0]);
    }

    private static class RouteTableModel extends AbstractTableModel {
        private final Route[] routes;

        private static final String[] COLUMN_NAMES = {
                "Start", "End", "Distance"
        };

        public RouteTableModel(Route[] routes) {
            this.routes = routes;
        }

        @Override
        public int getRowCount() {
            return routes.length;
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
            Route route = routes[rowIndex];
            switch (columnIndex) {
                case 0:
                    return route.getStart();
                case 1:
                    return route.getEnd();
                case 2:
                    return route.getDistance();
                default:
                    return null;
            }
        }
    }
}