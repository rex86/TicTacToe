package trial;

import gui.GuiTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

public class GameController {
    Counter counterPlayer1,counterPlayer2 = null;
    int flag = 0;
    final int NUMBEROFDOTCOUNT = 5;
    final int TICTACTOEGAMETABLESIZE = 30; //you can change the table size between 3 and 1000

    int[][] ticTacToeMatrix = new int[TICTACTOEGAMETABLESIZE][TICTACTOEGAMETABLESIZE];
    boolean win = false, isEmpty;
    String winnerName = "";
    MatrixWorker matrixWorker = new MatrixWorker(ticTacToeMatrix);
    Player player1 = new Player("Rex", "X");
    Player player2 = new Player("Moni", "O");
    //Table table = new Table(matrixWorker);
    Dimension panelSize;
    Graphics2D graphics2D;
    GuiTable guiTable = new GuiTable(this,TICTACTOEGAMETABLESIZE);
    InputStream stream;
    String fileNameXIcon = "/skydive.gif";
    ImageIcon icon;
    public GameController() {

        guiTable.setVisible(true);

    }

    public void command(String command,JLabel panel){

        switch (command){
            case "click":
                doCheckAndSet(panel);
                break;
        }
    }

    private void doCheckAndSet(JLabel panel) {
        String row,column;
        String [] stringArrayFromSplit;
        counterPlayer1 = new Counter(matrixWorker, player1);
        counterPlayer2 = new Counter(matrixWorker, player2);
        graphics2D = (Graphics2D) panel.getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.setStroke(new BasicStroke(2.5f));

        panelSize = panel.getSize();

        //InputStream file = ClassLoader.class.getResourceAsStream(fileName);


        stream = getClass().getResourceAsStream(fileNameXIcon);
        try {
            icon = new ImageIcon(ImageIO.read(stream));

        }catch (IOException ex){
            System.out.println(ex);
        }
        //ImageIcon ii = new ImageIcon(getClass().getResource(fileNameXIcon));

        URL urlImage = GameController.class.getResource(fileNameXIcon);
        ImageIcon x_Icon = new ImageIcon(urlImage);

        ImageIcon icon = new ImageIcon(urlImage);
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, 10  , 10, null);
        ImageIcon newIcon = new ImageIcon(bi);

        panel.setOpaque(true);
        panel.setIcon(newIcon);
        //if(panel.getBackground() != Color.BLUE && panel.getBackground() != Color.RED) {
        if(panel.getBackground() == Color.WHITE) {

            //because of xx,yyy,zzzz digits, for example: col 11, row 11...
            stringArrayFromSplit = panel.getName().split("-");
            row = stringArrayFromSplit[0];
            column = stringArrayFromSplit[1];
            matrixWorker.setPosition(Integer.parseInt(row) + 1,Integer.parseInt(column) + 1);
            if (flag == 0) {
                //graphics2D.setColor(Color.BLACK);
                //graphics2D.draw(new Ellipse2D.Double(3,3,panelSize.getWidth()-7,panelSize.getHeight()-7));
                //panel.setIcon(x_Icon);
                matrixWorker.setCellValue(player1.getPiece().equals("X")?1:2);
                flag = 1;
            } else {
                //panel.setBackground(Color.RED);
               // graphics2D.setColor(Color.RED);

                //graphics2D.draw(new Line2D.Double(3,3,27,27));
                //graphics2D.draw(new Line2D.Double(3,27,27,3));

                matrixWorker.setCellValue(player2.getPiece().equals("X")?1:2);
                flag = 0;
            }

            win = isWin(counterPlayer1) || isWin(counterPlayer2);
            if(win && flag == 0){
                winnerName = player2.getName();
            }else if(win && flag == 1){
                winnerName = player1.getName();
            }
            if(!winnerName.isEmpty()){
                JOptionPane.showMessageDialog(guiTable,"Winner is: " + winnerName);
                newGame();

            }
        //printArray(ticTacToeMatrix);
        }

    }
    private void newGame(){
        //Reset to default
        matrixWorker.resetArray();
        guiTable.resetTable();
        guiTable.clearGuiTableDraw();

        win = false;
        winnerName = "";
        flag = 0;


    }

    public static void main(String[] args) {
        new GameController();
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

    boolean isWin(Counter counter) {

        return  counter.count("row") >= NUMBEROFDOTCOUNT ||
                counter.count("column") >= NUMBEROFDOTCOUNT ||
                counter.count("diagonalUp") >= NUMBEROFDOTCOUNT ||
                counter.count("diagonalDown") >= NUMBEROFDOTCOUNT;
    }
}


