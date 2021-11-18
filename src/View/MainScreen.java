package View;

import javax.swing.*;

public class MainScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonLogin, buttonRegister, buttonLihatData;
    DefaultComponentSettings GUI = new DefaultComponentSettings();

    public MainScreen() {
        //Frame
        frame = GUI.defaultFrame();

        //Panel
        panel = GUI.defaultPanel();

        //Button login
        buttonLogin = GUI.defaultButton("Login");
        buttonLogin.setBounds(200, 200, 200, 50);
        buttonLogin.addActionListener(e -> {
            frame.dispose();
            new LoginScreen();
        });

        //Button Register
        buttonRegister = GUI.defaultButton("Register");
        buttonRegister.setBounds(200, 300, 200, 50);
        buttonRegister.addActionListener(e -> {
            frame.dispose();
            new RegisterScreen();
        });

        //Button Lihat Data
        buttonLihatData = GUI.defaultButton("Lihat Data");
        buttonLihatData.setBounds(200, 400, 200, 50);
        buttonLihatData.addActionListener(e -> {
            frame.dispose();
            new SeeDataScreen();
        });

        //Add to panel
        panel.add(buttonLogin);
        panel.add(buttonRegister);
        panel.add(buttonLihatData);

        //Add To Frame
        frame.add(panel);
    }
}
