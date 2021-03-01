package NetworkChat.GUI;

import NetworkChat.client.ClientApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SiqnIn extends JFrame {
    private JPanel contentPane;
    private JTextField userLoginField;
    private JPasswordField userPasswordField;
    private JButton btnNewButton;
    private JButton btnRegistration;

    public SiqnIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 550, 450);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Войти в чат");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 42));
        lblNewUserRegister.setBounds(140, 50, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel userLogin = new JLabel("Login ");
        userLogin.setFont(new Font("Roboto", Font.PLAIN, 20));
        userLogin.setBounds(58, 140, 99, 43);
        contentPane.add(userLogin);

        JLabel userPassword = new JLabel("Password ");
        userPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
        userPassword.setBounds(58, 220, 110, 29);
        contentPane.add(userPassword);

        userLoginField = new JTextField();
        userLoginField.setFont(new Font("Roboto", Font.PLAIN, 25));
        userLoginField.setBounds(214, 140, 228, 50);
        contentPane.add(userLoginField);
        userLoginField.setColumns(10);

        userPasswordField = new JPasswordField();
        userPasswordField.setFont(new Font("Roboto", Font.PLAIN, 25));
        userPasswordField.setBounds(214, 220, 228, 50);
        contentPane.add(userPasswordField);
        userPasswordField.setColumns(10);

        btnNewButton = new JButton("Войти");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    new ClientApp(userLoginField.getText(), userPasswordField.getText()).start();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 15));
        btnNewButton.setBounds(214, 280, 150, 50);
        contentPane.add(btnNewButton);

        btnRegistration = new JButton("Регистрация");
        btnRegistration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RegistrationPanel().setVisible(true);
            }
        });
        btnRegistration.setFont(new Font("Roboto", Font.PLAIN, 15));
        btnRegistration.setBounds(214, 340, 150, 50);
        contentPane.add(btnRegistration);

    }
}