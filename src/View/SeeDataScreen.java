package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeeDataScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonLihatData, buttonBack;
    JLabel labelCategory, labelPassword;
    JTextField inputEmail;
    JPasswordField inputPassword;
    JComboBox inputCategory;

    public SeeDataScreen(){
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

        //Label Kategori
        labelCategory = new JLabel("Category");
        labelCategory.setFont(new Font("Verdana",Font.PLAIN,16));
        labelCategory.setBounds(100,200,150,40);

        //Label Combo box
        Controller controller = new Controller();
        String[] listKategori = new String[3];
        ArrayList<String> listCategory = controller.getListOfCategory();
        for (int i = 0; i < listCategory.size(); i++) {
            listKategori[i] = listCategory.get(i);
        }

        inputCategory = new JComboBox(listKategori);
        inputCategory.setBounds(255,200,250,40);

        //Button Register
        buttonLihatData = new JButton("See Data");
        buttonLihatData.setBounds(100, 500, 200, 40);
        buttonLihatData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jenis = inputCategory.getSelectedIndex();
                Controller c = new Controller();
                ArrayList<User> listUser = c.getDataUser(jenis+1);
                for (int i = 0; i < listUser.size(); i++) {
                    System.out.println(listUser.get(i).getName());
                }
            }
        });

        //Add to panel
        panel.add(labelCategory);
        panel.add(inputCategory);
        panel.add(buttonLihatData);

        //Add To Frame
        frame.add(panel);

    }
}
