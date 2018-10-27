package gui;

import trial.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiTable extends JFrame implements MouseListener{

    Container cp = getContentPane();
    JLabel [][] jLabels;
    final Color emptyColor = Color.WHITE;
    final Color testColor = Color.RED;
    GameController gameController;
    int ticTacToeTableSize;
    JPanel tablePanel, namePanel;
    AddPlayerPanel addPlayerPanel = new AddPlayerPanel();
    ResultPanel resultPanel = new ResultPanel();

    public void setTicTacToeTableSize(int ticTacToeTableSize) {
        if(ticTacToeTableSize > 4 && ticTacToeTableSize < 1001){
            this.ticTacToeTableSize = ticTacToeTableSize;
        }else{
            System.out.println("Please set between 3 and 1000");
        }

    }


    public GuiTable(GameController gameController, int ticTacToeTableSize){
        this.gameController = gameController;
        jLabels = new JLabel[ticTacToeTableSize][ticTacToeTableSize];
        setTicTacToeTableSize(ticTacToeTableSize);
        initGui();

    }

    public void initGui(){


        setTitle("TicTacToeGame");
        setPreferredSize(new Dimension(1200,1024));
        setResizable(false);
        tablePanel = new JPanel(new GridLayout(ticTacToeTableSize,ticTacToeTableSize));

        Border paddingBorder = BorderFactory.createEmptyBorder(0,0,0,0);
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        for(int i = 0; i<jLabels.length;i++){
            for(int j = 0; j<jLabels[0].length;j++){
                jLabels[i][j] = new JLabel();
                jLabels[i][j].setOpaque(true);
                jLabels[i][j].setName(i+"-"+j); //we have to split it in the controller class
                jLabels[i][j].addMouseListener(this);
                jLabels[i][j].setBackground(emptyColor);
                jLabels[i][j].setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
                tablePanel.add(jLabels[i][j]);
            }
        }


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cp.add(addPlayerPanel,BorderLayout.EAST);
        cp.add(resultPanel);
        cp.add(tablePanel);

        pack();

    }

    public void resetTable() {
        for (int i = 0; i < jLabels.length; i++) {
            for (int j = 0; j < jLabels[0].length; j++) {
                jLabels[i][j].setIcon(null);

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gameController.command("click", e.getComponent());
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


