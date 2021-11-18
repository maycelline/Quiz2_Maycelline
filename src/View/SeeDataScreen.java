package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;
import java.util.ArrayList;

public class SeeDataScreen {
    JFrame frame, frameTable;
    JPanel panel;
    JButton buttonLihatData, buttonBack;
    JLabel labelCategory;
    JTable table;
    JComboBox inputCategory;
    DefaultComponentSettings GUI = new DefaultComponentSettings();
    ArrayList<User> listUser;
    String[] column;
    String[][] data;

    public SeeDataScreen() {
        //Frame
        frame = GUI.defaultFrame();

        //Panel
        panel = GUI.defaultPanel();

        //Label Kategori
        labelCategory = GUI.regularText("Category");
        labelCategory.setBounds(100, 200, 150, 40);

        //Label Combo box
        Controller controller = new Controller();
        String[] listKategori = controller.getListOfCategory();
        inputCategory = new JComboBox(listKategori);
        inputCategory.setBounds(255, 200, 250, 40);

        //Button Register
        buttonLihatData = GUI.defaultButton("Lihat Data");
        buttonLihatData.setBounds(67, 400, 200, 40);
        buttonLihatData.addActionListener(e -> {
            int jenis = inputCategory.getSelectedIndex();
            Controller c = new Controller();
            listUser = c.getDataUser(jenis + 1);
            column = new String[]{"ID", "Name", "Email", "Password"};
            data = new String[listUser.size()][column.length];
            for (int i = 0; i < listUser.size(); i++) {
                for (int j = 0; j < column.length; j++) {
                    switch (j) {
                        case 0:
                            data[i][j] = String.valueOf(listUser.get(i).getId());
                            break;
                        case 1:
                            data[i][j] = listUser.get(i).getName();
                            break;
                        case 2:
                            data[i][j] = listUser.get(i).getEmail();
                            break;
                        case 3:
                            data[i][j] = listUser.get(i).getPassword();
                            break;
                    }
                }
            }
            frame.dispose();
            showTable();

        });

        buttonBack = GUI.defaultButton("Back");
        buttonBack.setBounds(334, 400, 200, 40);
        buttonBack.addActionListener(e -> {
            frame.dispose();
            new MainScreen();
        });
        frame.add(buttonBack);

        //Add to panel
        panel.add(labelCategory);
        panel.add(inputCategory);
        panel.add(buttonLihatData);

        //Add To Frame
        frame.add(panel);
    }

    public void showTable() {
        frameTable = GUI.defaultFrame();
        frameTable.setLayout(null);
        table = new JTable(data, column);
        table.setBounds(0, 100, 600, 700);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 600, 700);
        frameTable.add(scrollPane);

        buttonBack = GUI.defaultButton("Back");
        buttonBack.setBounds(10, 10, 200, 40);
        buttonBack.addActionListener(e -> {
            frameTable.dispose();
            new SeeDataScreen();
        });
        frameTable.add(buttonBack);
    }
}
