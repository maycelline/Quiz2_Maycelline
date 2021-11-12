package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonLogin, buttonRegister, buttonLihatData;
    public MainScreen(){
        //Frame
        frame = new JFrame("Quiz 2");
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //Panel
        panel = new JPanel();
        panel.setSize(600,800);
        panel.setLayout(null);

        //Button login
        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(200, 200, 200, 50);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginScreen();
            }
        });

        //Button Register
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(200, 300, 200, 50);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new RegisterScreen();
            }
        });

        //Button Lihat Data
        buttonLihatData = new JButton("Lihat Data");
        buttonLihatData.setBounds(200,400, 200,50);
        buttonLihatData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new SeeDataScreen();
            }
        });

        //Add to panel
        panel.add(buttonLogin);
        panel.add(buttonRegister);
        panel.add(buttonLihatData);


        //Add To Frame
        frame.add(panel);
    }
}
