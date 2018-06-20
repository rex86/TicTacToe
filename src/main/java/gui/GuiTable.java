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
                //jLabels[i][j].getGraphics().drawLine(0,0,5,5);
                //jLabels[i][j].setIcon(new ImageIcon(getClass().getResource("X_Icon.png")));
                tablePanel.add(jLabels[i][j]);
            }
        }




        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*setLayout(new BorderLayout());
        namePanel = new JPanel(new FlowLayout());
        //namePanel.setPreferredSize(new Dimension(200,100));
        JLabel labelName = new JLabel("Név: ",SwingConstants.LEFT);
        JTextField tfName = new JTextField(10);
        namePanel.add(labelName);
        namePanel.add(tfName);
*/
        cp.add(addPlayerPanel,BorderLayout.EAST);
        cp.add(resultPanel);
        cp.add(tablePanel);
        //cp.add(namePanel, BorderLayout.EAST);

        pack();

    }

    public void resetTable() {
        for (int i = 0; i < jLabels.length; i++) {
            for (int j = 0; j < jLabels[0].length; j++) {
                jLabels[i][j].setIcon(null);

            }
        }
    }

    public void clearGuiTableDraw(){
        tablePanel.repaint();

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        gameController.command("click", (JLabel)e.getComponent());
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


