package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiTable extends JFrame implements MouseListener{

    Container cp = getContentPane();
    JLabel [][] jLabels = new JLabel[3][3];

    public GuiTable(){
        initGui();
    }

    public void initGui(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToeGame");
        setPreferredSize(new Dimension(300,200));
        JPanel tablePanel = new JPanel(new GridLayout(3,3));
        tablePanel.setBackground(Color.WHITE);
        JLabel jLabel1 = new JLabel("Teszt1");
        jLabel1.setBackground(Color.RED);
        jLabel1.setOpaque(true);

        //jLabel1.setSize(5,5);

        JLabel jLabel2 = new JLabel("Teszt 2");
        JLabel jLabel3 = new JLabel("Teszt 3");
        JLabel jLabel4 = new JLabel("Teszt 4");
        JLabel jLabel5 = new JLabel("Teszt 5");
        JLabel jLabel6 = new JLabel("Teszt 6");
        JLabel jLabel7 = new JLabel("Teszt 7");
        JLabel jLabel8 = new JLabel("Teszt 8");
        JLabel jLabel9 = new JLabel("Teszt 9");
        jLabel1.setName("Valami");

        jLabel2.setOpaque(true);
        jLabel3.setOpaque(true);
        jLabel4.setOpaque(true);
        jLabel5.setOpaque(true);
        jLabel6.setOpaque(true);
        jLabel7.setOpaque(true);
        jLabel8.setOpaque(true);
        jLabel9.setOpaque(true);

        jLabel1.addMouseListener(this);
        jLabel2.addMouseListener(this);
        jLabel3.addMouseListener(this);
        jLabel4.addMouseListener(this);
        jLabel5.addMouseListener(this);
        jLabel6.addMouseListener(this);
        jLabel7.addMouseListener(this);
        jLabel8.addMouseListener(this);
        jLabel9.addMouseListener(this);


        tablePanel.add(jLabel1);
        tablePanel.add(jLabel2);
        tablePanel.add(jLabel3);
        tablePanel.add(jLabel4);
        tablePanel.add(jLabel5);
        tablePanel.add(jLabel6);
        tablePanel.add(jLabel7);
        tablePanel.add(jLabel8);
        tablePanel.add(jLabel9);
        cp.add(tablePanel);

        pack();
        setVisible(true);



    }

    public static void main(String[] args) {
        new GuiTable();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getComponent().getName());
        e.getComponent().setBackground(Color.BLACK);


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


