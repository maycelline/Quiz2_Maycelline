package View;

import Controller.Controller;
import Model.User;

import javax.swing.*;

public class SeeProfileScreen {
    JFrame frame;
    JPanel panel;
    JButton buttonEdit, buttonBack, buttonDelete, buttonSave;
    JLabel labelEmail, labelPassword, labelNama, labelKategori;
    JTextField inputEmail, inputNama, inputCategory2;
    JPasswordField inputPassword;
    JComboBox inputCategory;
    DefaultComponentSettings GUI = new DefaultComponentSettings();
    Controller controller = new Controller();

    public SeeProfileScreen(User user) {
        //Frame
        frame = GUI.defaultFrame();

        //Panel
        panel = GUI.defaultPanel();

        //Label Nama
        labelNama = GUI.regularText("Nama");
        labelNama.setBounds(100, 100, 150, 40);

        //Input Nama
        inputNama = new JTextField(user.getName());
        inputNama.setBounds(255, 100, 250, 40);
        inputNama.setEditable(false);

        //Label Nama
        labelEmail = GUI.regularText("Email");
        labelEmail.setBounds(100, 200, 150, 40);

        //Input Email
        inputEmail = new JTextField(user.getEmail());
        inputEmail.setBounds(255, 200, 250, 40);
        inputEmail.setEditable(false);

        //Label Password
        labelPassword = GUI.regularText("Password");
        labelPassword.setBounds(100, 300, 150, 40);

        //Input Password
        inputPassword = new JPasswordField(user.getPassword());
        inputPassword.setBounds(255, 300, 250, 40);
        inputPassword.setEditable(false);

        //Label Kategori
        labelKategori = GUI.regularText("Kategori");
        labelKategori.setBounds(100, 400, 150, 40);

        //Input Kategori (disable)
        String kategori = "";
        switch (user.getIdCategory()) {
            case 1:
                kategori = "Private Account";
                break;
            case 2:
                kategori = "Business Account";
                break;
            case 3:
                kategori = "Creator Account";
                break;
        }
        inputCategory2 = new JTextField(kategori);
        inputCategory2.setBounds(255, 400, 250, 40);
        inputCategory2.setEditable(false);
        //Input Kategori
        String[] listKategori = controller.getListOfCategory();
        inputCategory = new JComboBox(listKategori);
        inputCategory.setBounds(255, 400, 250, 40);
        inputCategory.setVisible(false);

        //Button Save
        buttonSave = GUI.defaultButton("Save");
        buttonSave.setVisible(false);
        buttonSave.setBounds(67, 500, 200, 40);
        buttonSave.addActionListener(e -> {
            String email = inputEmail.getText();
            String password = String.valueOf(inputPassword.getPassword());
            String name = inputNama.getText();
            int indexCategory = inputCategory.getSelectedIndex();

            if (password.length() < 8) {
                JOptionPane.showMessageDialog(null, "Password should not be less than 8");
            } else {
                boolean updated = controller.EditUser(user.getId(), name, email, password, indexCategory + 1);
                if (updated) {
                    JOptionPane.showMessageDialog(null, "Data Updated");
                    inputEmail.setEditable(false);
                    inputNama.setEditable(false);
                    inputPassword.setEditable(false);
                    buttonSave.setVisible(false);
                    buttonDelete.setVisible(false);
                    buttonEdit.setVisible(true);
                    inputCategory2.setText(listKategori[indexCategory]);
                    inputCategory2.setVisible(true);
                    inputCategory.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Masukkan data dengan benar.");
                }
            }
        });


        //Button Edit
        buttonEdit = GUI.defaultButton("Edit");
        buttonEdit.setBounds(67, 500, 200, 40);
        buttonEdit.addActionListener(e -> {
            buttonSave.setVisible(true);
            inputNama.setEditable(true);
            inputEmail.setEditable(true);
            inputCategory.setVisible(true);
            inputCategory2.setVisible(false);
            inputPassword.setEditable(true);
            buttonEdit.setVisible(false);
            buttonDelete.setVisible(true);
        });

        //Button Back
        buttonBack = GUI.defaultButton("Back");
        buttonBack.setBounds(334, 500, 200, 40);
        buttonBack.addActionListener(e -> {
            frame.dispose();
            new MainScreen();
        });

        //Button Delete
        buttonDelete = GUI.defaultButton("Delete");
        buttonDelete.setBounds(200, 600, 200, 40);
        buttonDelete.setVisible(false);
        buttonDelete.addActionListener(e -> {
            boolean deleted = controller.DeleteUser(user.getId());
            if (deleted) {
                JOptionPane.showMessageDialog(null, "Deleted");
                frame.dispose();
                new MainScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Not Deleted");
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
        panel.add(buttonSave);
        panel.add(labelKategori);
        panel.add(inputCategory);
        panel.add(inputCategory2);


        //Add To Frame
        frame.add(panel);
    }
}
