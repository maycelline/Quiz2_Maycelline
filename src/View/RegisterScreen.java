package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;

public class RegisterScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonRegister, buttonBack;
    JLabel labelEmail, labelPassword, labelKategori, labelNama;
    JTextField inputEmail, inputNama;
    JPasswordField inputPassword;
    JComboBox inputCategory;
    DefaultComponentSettings GUI = new DefaultComponentSettings();

    public RegisterScreen() {
        //Frame
        frame = GUI.defaultFrame();

        //Panel
        panel = GUI.defaultPanel();

        //Label Email
        labelEmail = GUI.regularText("Email");
        labelEmail.setBounds(100, 100, 150, 40);

        //Input Email
        inputEmail = new JTextField();
        inputEmail.setBounds(255, 100, 250, 40);

        //Label Nama
        labelNama = GUI.regularText("Nama");
        labelNama.setBounds(100, 200, 150, 40);

        //Input Email
        inputNama = new JTextField();
        inputNama.setBounds(255, 200, 250, 40);

        //Label Password
        labelPassword = GUI.regularText("Password");
        labelPassword.setBounds(100, 300, 150, 40);

        //Input Password
        inputPassword = new JPasswordField();
        inputPassword.setBounds(255, 300, 250, 40);

        //Label kategori
        labelKategori = GUI.regularText("Kategori");
        labelKategori.setBounds(100, 400, 150, 40);

        //Label Combo box
        Controller controller = new Controller();
        String[] listKategori = controller.getListOfCategory();
        inputCategory = new JComboBox(listKategori);
        inputCategory.setBounds(255, 400, 250, 40);

        //Button Register
        buttonRegister = GUI.defaultButton("Register");
        buttonRegister.setBounds(100, 500, 200, 40);
        buttonRegister.addActionListener(e -> {
            String password = String.valueOf(inputPassword.getPassword());
            String email = inputEmail.getText();
            if (password.length() < 8) {
                JOptionPane.showMessageDialog(null, "Password should not be less than 8");
            } else if (!controller.emailValidation(email)) {
                JOptionPane.showMessageDialog(null, "Enter the correct email address.");
            } else {
                String name = inputNama.getText();
                int category = inputCategory.getSelectedIndex();
                Controller controller1 = new Controller();
                int maxIndex = controller1.getTotalUserAtDB();
                System.out.println("Id user: " + (maxIndex + 1));
                User user = new User(maxIndex + 1, name, email, password, category + 1);
                boolean registered = controller1.Register(user);
                if (registered) {
                    JOptionPane.showMessageDialog(null, "Hello, " + user.getName() + "! Nice to see you!");
                    frame.dispose();
                    new SeeProfileScreen(user);
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan data dengan benar.");
                }
            }
        });

        //Button Back
        buttonBack = GUI.defaultButton("Back");
        buttonBack.setBounds(350, 500, 200, 40);
        buttonBack.addActionListener(e -> {
            frame.dispose();
            new MainScreen();
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
