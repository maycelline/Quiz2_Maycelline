package View;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class DefaultComponentSettings {
    public JLabel regularText(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Verdana", Font.PLAIN, 16));
        return label;
    }

    public JLabel headingText(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Verdana", Font.BOLD, 19));
        return label;
    }

    public JFrame defaultFrame() {
        JFrame frame = new JFrame("Quiz 2");
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        return frame;
    }

    public JPanel defaultPanel() {
        JPanel panel = new JPanel();
        panel.setSize(600, 800);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        return panel;
    }

    public JButton defaultButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(217, 217, 217));
        button.setBorder(new BevelBorder(1, Color.BLACK, Color.BLACK));
        button.setFont(new Font("Verdana", Font.BOLD, 14));
        return button;
    }
}
