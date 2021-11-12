package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfileScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonEdit, buttonBack, buttonDelete;
    JLabel labelEmail, labelPassword, labelNama;
    JTextField inputEmail, inputNama;
    JPasswordField inputPassword;
    JComboBox inputCategory;

    public EditProfileScreen(User user) {
        //Frame
        frame = new JFrame("Quiz 2");
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //Panel
        panel = new JPanel();
        panel.setSize(600, 800);
        panel.setLayout(null);

        //Label Nama
        labelNama = new JLabel("Nama");
        labelNama.setFont(new Font("Verdana", Font.PLAIN, 16));
        labelNama.setBounds(100, 100, 150, 40);

        //Input Nama
        inputNama = new JTextField(user.getName());
        inputNama.setBounds(255, 100, 250, 40);

        //Label Nama
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Verdana", Font.PLAIN, 16));
        labelEmail.setBounds(100, 200, 150, 40);

        //Input Email
        inputEmail = new JTextField(user.getEmail());
        inputEmail.setBounds(255, 200, 250, 40);

        //Label Password
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
        labelPassword.setBounds(100, 300, 150, 40);

        //Input Password
        inputPassword = new JPasswordField(user.getPassword());
        inputPassword.setBounds(255, 300, 250, 40);

        //Button Register
        buttonEdit = new JButton("Edit");
        buttonEdit.setBounds(100, 500, 200, 40);
        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = inputEmail.getText();
                String password = String.valueOf(inputPassword.getPassword());
                String name = inputNama.getText();
                Controller controller = new Controller();

                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password should not be less than 8");
                } else {
                    boolean updated = controller.EditUser(user.getId(), name, email, password);
                    if (updated) {
                        JOptionPane.showMessageDialog(null, "Data Updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Masukkan data dengan benar.");
                    }
                }
            }
        });

        //Button Back
        buttonBack = new JButton("Back");
        buttonBack.setBounds(350, 500, 200, 40);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainScreen();
            }
        });

        //Button Delete
        buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(250, 600, 200, 40);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller();
                boolean deleted = controller.DeleteUser(user.getId());
                if(deleted){
                    JOptionPane.showMessageDialog(null, "deleted");
                    frame.dispose();
                    new MainScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Not deleted");
                }

            }
        });

        //Add to panel
        panel.add(buttonEdit);
        panel.add(labelNama);
        panel.add(inputNama);
        panel.add(labelEmail);
        panel.add(inputEmail);
        panel.add(labelPassword);
        panel.add(inputPassword);
        panel.add(buttonBack);
        panel.add(buttonDelete);

        //Add To Frame
        frame.add(panel);
    }
}
