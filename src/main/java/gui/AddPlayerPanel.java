package gui;

import trial.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayerPanel extends JPanel implements ActionListener{

    private JTextField jtp1;
    private JTextField jtp2;
    private JButton btOk;


    public AddPlayerPanel(){
        JPanel pnP1 = new JPanel();

        pnP1.setLayout(new GridLayout(3,1));

        jtp1 = new JTextField(7);
        jtp1.setText(GameController.getPlayer1().getName());
        jtp2 = new JTextField(7);
        jtp2.setText(GameController.getPlayer2().getName());
        pnP1.add(new JLabel("Player1 [o]:"));

        pnP1.add(jtp1);
        pnP1.add(new JLabel("Player2 [x]:"));
        pnP1.add(jtp2);
        btOk = new JButton("OK");
        btOk.addActionListener(this);
        pnP1.add(btOk);
        add(pnP1);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //Set player's name
        GameController.setPlayer1(jtp1.getText());
        GameController.setPlayer2(jtp2.getText());
    }
}
