package gui;

import javax.swing.*;

public class ResultPanel extends JPanel {

    private JTextArea jTextAreaResult;

    public ResultPanel(){

        jTextAreaResult = new JTextArea(15,20);
        add(jTextAreaResult);
    }
}
