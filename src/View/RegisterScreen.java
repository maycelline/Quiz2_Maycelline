package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonRegister, buttonBack;
    JLabel labelEmail, labelPassword, labelKategori, labelNama;
    JTextField inputEmail, inputNama;
    JPasswordField inputPassword;
    JComboBox inputCategory;
    public RegisterScreen(){
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
        labelEmail.setBounds(100,100,150,40);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(255,100,250,40);

        //Label Nama
        labelNama = new JLabel("Nama");
        labelNama.setFont(new Font("Verdana",Font.PLAIN,16));
        labelNama.setBounds(100,200,150,40);

        //Input Email
        inputNama = new JTextField();
        inputNama.setBounds(255,200,250,40);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Verdana",Font.PLAIN,16));
        labelPassword.setBounds(100,300,150,40);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(255,300, 250,40);

        //Label kategori
        labelKategori = new JLabel("Pilih Kategori");
        labelKategori.setBounds(100, 400, 150,40);

        //Label Combo box
        Controller controller = new Controller();
        String[] listKategori = new String[3];
        ArrayList<String> listCategory = controller.getListOfCategory();
        for (int i = 0; i < listCategory.size(); i++) {
            listKategori[i] = listCategory.get(i);
        }

        inputCategory = new JComboBox(listKategori);
        inputCategory.setBounds(255,400,250,40);

        //Button Register
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(100, 500, 200, 40);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = inputEmail.getText();
                String password = String.valueOf(inputPassword.getPassword());
                String name= inputNama.getText();
                int category = inputCategory.getSelectedIndex();
                Controller controller = new Controller();
                int maxIndex = controller.getTotalUserAtDB();
                System.out.println(maxIndex);
                User user = new User(maxIndex+1,name,email,password,category+1);
                if(password.length()<8){
                    JOptionPane.showMessageDialog(null, "Password should not be less than 8");
                } else {
                    boolean registered = controller.Register(user);

                    if(registered){
                        JOptionPane.showMessageDialog(null, "Hello, "+user.getName()+"! Nice to see you!");
                        frame.dispose();
                        new EditProfileScreen(user);
                    } else{
                        JOptionPane.showMessageDialog(null, "Masukkan data dengan benar.");
                    }
                }
            }
        });

        //Button Back
        buttonBack = new JButton("Back");
        buttonBack.setBounds(350,500,200,40);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainScreen();
            }
        });

        //Add to panel
        panel.add(buttonRegister);
        panel.add(labelNama);
        panel.add(inputNama);
        panel.add(labelEmail);
        panel.add(inputEmail);
        panel.add(labelPassword);
        panel.add(inputPassword);
        panel.add(labelKategori);
        panel.add(inputCategory);
        panel.add(buttonBack);


        //Add To Frame
        frame.add(panel);
    }
}
