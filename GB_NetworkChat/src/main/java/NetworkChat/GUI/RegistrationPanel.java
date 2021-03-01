package NetworkChat.GUI;

import NetworkChat.client.RegistrationUser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegistrationPanel extends JFrame {
    private JPanel contentPane;
    private JTextField userLoginField;
    private JTextField userPasswordField;
    private JTextField userNameField;
    private JButton btnNewButton;

    public RegistrationPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 550, 450);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Регистрация");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 42));
        lblNewUserRegister.setBounds(130, 50, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel userName = new JLabel("Name ");
        userName.setFont(new Font("Roboto", Font.PLAIN, 20));
        userName.setBounds(58, 140, 99, 43);
        contentPane.add(userName);

        JLabel userLogin = new JLabel("Login ");
        userLogin.setFont(new Font("Roboto", Font.PLAIN, 20));
        userLogin.setBounds(58, 200, 99, 43);
        contentPane.add(userLogin);

        JLabel userPassword = new JLabel("Password ");
        userPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
        userPassword.setBounds(58, 260, 99, 43);
        contentPane.add(userPassword);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Roboto", Font.PLAIN, 25));
        userNameField.setBounds(214, 140, 228, 50);
        contentPane.add(userNameField);
        userNameField.setColumns(10);

        userLoginField = new JTextField();
        userLoginField.setFont(new Font("Roboto", Font.PLAIN, 25));
        userLoginField.setBounds(214, 200, 228, 50);
        contentPane.add(userLoginField);
        userLoginField.setColumns(10);

        userPasswordField = new JTextField();
        userPasswordField.setFont(new Font("Roboto", Font.PLAIN, 25));
        userPasswordField.setBounds(214, 260, 228, 50);
        contentPane.add(userPasswordField);
        userPasswordField.setColumns(10);

        btnNewButton = new JButton("Регистрация");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //setVisible(false);
                    boolean test = new RegistrationUser().RegistrationUser(userNameField.getText(), userLoginField.getText(), userPasswordField.getText());
                    if (test) {
                        new SiqnIn().setVisible(true);
                        setVisible(false);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 15));
        btnNewButton.setBounds(214, 320, 150, 50);
        contentPane.add(btnNewButton);

    }
}
