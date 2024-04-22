package SantanderSAS.View;

import SantanderSAS.Model.Messenger.Messenger;
import SantanderSAS.Model.Observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.function.UnaryOperator;

public class SGTTPView extends Observer<Messenger> {
    private final JFrame frame;
    private final JButton button;
    private final JPanel panelButton;
    private final JPanel panelConsole;
    private final JLabel console;

    public SGTTPView(String title, Messenger messenger) {
        super(messenger);
        subject.attach(this);

        frame = new JFrame(title);
        button = new JButton("Start Server");
        panelButton = new JPanel();
        panelConsole = new JPanel();
        console = new JLabel("Server Status: Stopped");
    }

    public void initComponent(UnaryOperator<Void> fn) {
        console.setOpaque(true);
        console.setBackground(new Color(255, 255, 255));
        panelConsole.add(console);
        panelConsole.setLayout(new GridLayout(1, 1));
        panelButton.setLayout(new GridLayout(3, 3));

        startButton(fn);

        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 1));
        frame.add(panelButton);
        frame.add(panelConsole);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void startButton(UnaryOperator<Void> fn) {
        button.addActionListener(event -> fn.apply(null));
        for (int i = 0; i < 6; i++) {
            if (i == 4) {
                panelButton.add(button);
            }
            panelButton.add(new JLabel());
        }
    }

    public void showServerStatus(String status) {
        button.setText(status);
        button.setEnabled(false);
    }

    @Override
    public void update() {
        console.setText("Server Status: " + subject.getMessage());
    }
}
