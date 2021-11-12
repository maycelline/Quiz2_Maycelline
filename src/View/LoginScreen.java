package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonLogin, buttonBack;
    JLabel labelEmail, labelPassword;
    JTextField inputEmail;
    JPasswordField inputPassword;
    public LoginScreen(){
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

        //Label Email
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Verdana",Font.PLAIN,16));
        labelEmail.setBounds(100,200,150,40);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(255,200,250,40);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Verdana",Font.PLAIN,16));
        labelPassword.setBounds(100,300,150,40);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(255,300, 250,40);

        //Button Login
        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(100, 400, 200, 40);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = inputEmail.getText();
                String password = String.valueOf(inputPassword.getPassword());
                Controller controller = new Controller();
                User user = controller.LogIn(email,password);

                if(user != null){
                    JOptionPane.showMessageDialog(null, "Welcome Back, "+user.getName()+"!");
                    frame.dispose();
                    new EditProfileScreen(user);
                } else{
                    JOptionPane.showMessageDialog(null, "Masukkan data dengan benar.");
                }
            }
        });

        //Button Back
        buttonBack = new JButton("Back");
        buttonBack.setBounds(350,400,200,40);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainScreen();
            }
        });

        //Add to panel
        panel.add(buttonLogin);
        panel.add(labelEmail);
        panel.add(inputEmail);
        panel.add(labelPassword);
        panel.add(inputPassword);
        panel.add(buttonBack);


        //Add To Frame
        frame.add(panel);

    }
}
