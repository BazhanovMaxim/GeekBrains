package prev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Form extends JFrame {
    public Form(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 550);

        JPanel chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JTextArea textOfChat = new JTextArea();
        textOfChat.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        textOfChat.setLineWrap(true);
        textOfChat.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(textOfChat);
        chatPanel.add(jScrollPane);

        add(chatPanel);

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JTextField inputField = new JTextField();
        inputField.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        inputField.addActionListener(new ActionListener() {
            private final StringBuilder stringBuilder = new StringBuilder(textOfChat.getText());
            final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm: ");
            final Date date = new Date(System.currentTimeMillis());

            @Override
            public void actionPerformed(ActionEvent e) {


                if (inputField.getText().isEmpty()) {
                    return;
                }

                stringBuilder.append(textOfChat.getText())
                        .append(formatter.format(date))
                        .append(inputField.getText())
                        .append("\n");
                textOfChat.setText(stringBuilder.toString());
                inputField.setText("");
                stringBuilder.setLength(0);
            }
        });

        JButton clickToSend = new JButton("Send");
        clickToSend.addActionListener(new SubmitButtonListener(inputField, textOfChat));
        controlPanel.add(clickToSend, BorderLayout.EAST);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
