package gui;

import javax.swing.*;
import java.awt.*;

public class AddPlayerPanel extends JPanel{

    private JTextField jtp1;
    private JTextField jtp2;
    private JButton btOk;
    public AddPlayerPanel(){

        setLayout(new GridLayout(3,1));
        //setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        JPanel pnP1 = new JPanel();
        JPanel pnP2 = new JPanel();

        jtp1 = new JTextField("Rex",7);
        jtp2 = new JTextField("Moni",7);
        pnP1.add(new JLabel("Player1: "));
        pnP1.add(jtp1);
        add(pnP1);

        pnP2.add(new JLabel("Player2: "));
        pnP2.add(jtp2);
        add(pnP2);

        btOk = new JButton("OK");
        add(btOk);


    }
}
