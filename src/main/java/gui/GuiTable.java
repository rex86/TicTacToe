package gui;

import javax.swing.*;
import java.awt.*;

public class GuiTable extends JFrame{

    Container cp = getContentPane();
    public GuiTable(){
        initGui();
    }

    public void initGui(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToGame");
        setPreferredSize(new Dimension(600,800));
        cp.add(new JPanel());
        cp.add(new JPanel());

        pack();
        setVisible(true);



    }

    public static void main(String[] args) {
        new GuiTable();
    }
}
