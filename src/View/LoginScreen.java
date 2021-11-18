package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;

public class LoginScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonLogin, buttonBack;
    JLabel labelEmail, labelPassword, labelLogo, labelJudul;
    JTextField inputEmail;
    JPasswordField inputPassword;
    ImageIcon logo;
    DefaultComponentSettings GUI = new DefaultComponentSettings();

    public LoginScreen() {
        //Frame
        frame = GUI.defaultFrame();

        //Panel
        panel = GUI.defaultPanel();

        //Logo
        labelLogo = new JLabel();
        logo = new ImageIcon("assets/hospital.png");
        labelLogo.setIcon(logo);
        labelLogo.setBounds(100, 90, 100, 100);

        //Hospital
        labelJudul = GUI.headingText("Rumah Sakit Anticry");
        labelJudul.setBounds(220, 120, 350, 40);

        //Label Email
        labelEmail = GUI.regularText("Email");
        labelEmail.setBounds(100, 240, 150, 40);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(255, 240, 250, 40);

        //Label Password
        labelPassword = GUI.regularText("Password");
        labelPassword.setBounds(100, 340, 150, 40);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(255, 340, 250, 40);

        //Button Login
        buttonLogin = GUI.defaultButton("Login");
        buttonLogin.setBounds(100, 440, 200, 40);
        buttonLogin.addActionListener(e -> {
            String email = inputEmail.getText();
            String password = String.valueOf(inputPassword.getPassword());
            Controller controller = new Controller();
            User user = controller.LogIn(email, password);

            if (user != null) {
                JOptionPane.showMessageDialog(null, "Welcome Back, " + user.getName() + "!");
                frame.dispose();
                new SeeProfileScreen(user);
            } else {
                JOptionPane.showMessageDialog(null, "Masukkan data dengan benar.");
            }
        });

        //Button Back
        buttonBack = GUI.defaultButton("Back");
        buttonBack.setBounds(350, 440, 200, 40);
        buttonBack.addActionListener(e -> {
            frame.dispose();
            new MainScreen();
        });

        //Add to panel
        panel.add(buttonLogin);
        panel.add(labelEmail);
        panel.add(inputEmail);
        panel.add(labelPassword);
        panel.add(inputPassword);
        panel.add(buttonBack);
        panel.add(labelLogo);
        panel.add(labelJudul);

        //Add To Frame
        frame.add(panel);
    }
}
