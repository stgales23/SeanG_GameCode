package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {
    private JTextArea mainDisplay;
    private JTextField input;

    public GameGUI() {
        buildWindow();
    }

    public void print(Object obj) {
        mainDisplay.append(obj.toString() + "\n");
    }

    public void actionPerformed(ActionEvent e) {
        String command = input.getText();
        Game.processCommand(command);
        input.setText("");  // Clear the input field after processing the command
    }

    private void buildWindow() {
        setTitle("Hotel Game");
        setLayout(new BorderLayout());

        mainDisplay = new JTextArea();
        mainDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mainDisplay);

        input = new JTextField();
        input.addActionListener(this);

        JPanel southPanel = new JPanel(new GridLayout(3, 1));
        JLabel label = new JLabel("What would you like to do?");
        JButton button = new JButton("Execute");
        button.addActionListener(this);

        southPanel.add(label);
        southPanel.add(input);
        southPanel.add(button);

        add(scrollPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

