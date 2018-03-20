package gui;

import trial.MatrixWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiTable extends JFrame implements MouseListener{

    Container cp = getContentPane();
    JLabel [][] jLabels = new JLabel[3][3];
    final Color emptyColor = Color.WHITE;
    final Color testColor = Color.RED;
    MatrixWorker matrixWorker;

    public GuiTable(){
        initGui();
    }
    public void printArray(int[][] arrayName){
        int i,j;
        for(i = 0 ; i<arrayName.length;i++){
            for(j = 0 ; j<arrayName.length;j++){
                System.out.print(arrayName[i][j]+", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void initGui(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToeGame");
        setPreferredSize(new Dimension(300,200));
        JPanel tablePanel = new JPanel(new GridLayout(3,3));


        int[][] ticTacToeMatrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},

        };
        matrixWorker = new MatrixWorker(ticTacToeMatrix);

        for(int i = 0; i<jLabels.length;i++){
            for(int j = 0; j<jLabels[0].length;j++){
                jLabels[i][j] = new JLabel("1");
                jLabels[i][j].setOpaque(true);
                jLabels[i][j].setName(i+""+j);
                jLabels[i][j].addMouseListener(this);
                jLabels[i][j].setBackground(emptyColor);

                tablePanel.add(jLabels[i][j]);
            }
        }

        /*
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
        JLabel jLabel9 = new JLabel();
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
        */

        cp.add(tablePanel);

        pack();
        setVisible(true);



    }

    public static void main(String[] args) {
        new GuiTable();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String row,column;
        //printArray(matrixWorker.getTicTacToeMatrix());
        if(e.getComponent().getBackground() != testColor){

            row = e.getComponent().getName().substring(0,1);
            column = e.getComponent().getName().substring(1,2);

            //System.out.println(e.getComponent().getName());
            e.getComponent().setBackground(testColor);
            //JLabel label = new JLabel(new ImageIcon("X_Icon.png"));

            matrixWorker.setPosition(Integer.parseInt(row)+1, Integer.parseInt(column)+1);

            matrixWorker.setCellValue(1);
            printArray(matrixWorker.getTicTacToeMatrix());

        }



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


