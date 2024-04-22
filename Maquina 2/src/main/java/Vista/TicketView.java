package Vista;

import Controller.TicketController;
import javax.swing.*;

public class TicketView {
    private JFrame frame;
    private JTextField idField;
    // Add more fields for each attribute in your TicketModel

    public TicketView() {
        frame = new JFrame("Ticket Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(10, 10, 80, 25);
        panel.add(idLabel);

        idField = new JTextField(20);
        idField.setBounds(100, 10, 160, 25);
        panel.add(idField);

        // Add more labels and text fields for each attribute in your TicketModel

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 80, 80, 25);
        panel.add(submitButton);

        // Add an action listener to your button to handle the click event
        submitButton.addActionListener(e -> {
            // Call your controller methods here to handle the data
        });

        frame.setVisible(true);
    }

    public String getId() {
        return idField.getText();
    }

    public void addPurchaseButton(TicketController controller) {
        JButton purchaseButton = new JButton("Comprar");
        purchaseButton.addActionListener(e -> controller.purchaseTicket());
        // Añade el botón a tu panel o donde quieras que aparezca
    }
}
