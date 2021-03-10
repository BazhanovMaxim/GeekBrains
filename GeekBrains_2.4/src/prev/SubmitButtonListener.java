package prev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmitButtonListener implements ActionListener {
    private final StringBuilder stringBuilder = new StringBuilder();
    private final JTextField jTextField;
    private final JTextArea jTextArea;

    public SubmitButtonListener(JTextField jTextField, JTextArea jTextArea) {
        this.jTextField = jTextField;
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm: ");
        Date date = new Date(System.currentTimeMillis());

        stringBuilder.append(jTextArea.getText())
                .append(formatter.format(date))
                .append(jTextField.getText())
                .append("\n");
        jTextArea.setText(stringBuilder.toString());
        jTextField.setText("");
        stringBuilder.setLength(0);
    }
}
