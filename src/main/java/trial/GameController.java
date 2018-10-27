package trial;

import gui.AddPlayerPanel;
import gui.GuiTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GameController{
    Counter counterPlayer1,counterPlayer2 = null;
    int flag = 0;
    final int NUMBEROFDOTCOUNT = 5;
    final int TICTACTOEGAMETABLESIZE = 30; //you can change the table size between 3 and 1000

    int[][] ticTacToeMatrix = new int[TICTACTOEGAMETABLESIZE][TICTACTOEGAMETABLESIZE];
    boolean win = false, isEmpty;
    String winnerName = "";
    MatrixWorker matrixWorker = new MatrixWorker(ticTacToeMatrix);
    static Player player1 = new Player("Rex", "X");
    static Player player2 = new Player("Moni", "O");

    Dimension panelSize;
    Graphics2D graphics2D;
    GuiTable guiTable = new GuiTable(this,TICTACTOEGAMETABLESIZE);
    InputStream stream;
    String fileNameXIcon = "/X_Icon.gif";
    String fileNameOIcon = "/O_Icon.gif";
    ImageIcon icon;
    AddPlayerPanel playerPanel = new AddPlayerPanel();

    public GameController() {
        guiTable.setVisible(true);

    }

    public void command(String command,Object object){

        switch (command){
            case "click":
                doCheckAndSet((JLabel) object);
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

        stream = getClass().getResourceAsStream(fileNameXIcon);
        try {
            icon = new ImageIcon(ImageIO.read(stream));

        }catch (IOException ex){
            System.out.println(ex);
        }

        URL urlImageX = GameController.class.getResource(fileNameXIcon);
        ImageIcon x_Icon = new ImageIcon(urlImageX);

        URL urlImageO = GameController.class.getResource(fileNameOIcon);
        ImageIcon o_Icon = new ImageIcon(urlImageO);

        //Resize X icon
        ImageIcon iconx = new ImageIcon(urlImageX);
        Image imgx = iconx.getImage();
        BufferedImage bix = new BufferedImage(imgx.getWidth(null), imgx.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics gx = bix.createGraphics();
        gx.drawImage(imgx, 0, 9, 30, 30, null);
        ImageIcon newIconx = new ImageIcon(bix);

        //Resize O icon
        ImageIcon icono = new ImageIcon(urlImageO);
        Image imgo = icono.getImage();
        BufferedImage bio = new BufferedImage(imgo.getWidth(null), imgo.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics go = bio.createGraphics();
        go.drawImage(imgo, 0, 9, 30, 30, null);
        ImageIcon newIcono = new ImageIcon(bio);
        isEmpty = panel.getIcon() == null?true:false;

        if(isEmpty) {

            //because of xx,yyy,zzzz digits, for example: col 11, row 11...
            stringArrayFromSplit = panel.getName().split("-");
            row = stringArrayFromSplit[0];
            column = stringArrayFromSplit[1];
            matrixWorker.setPosition(Integer.parseInt(row) + 1,Integer.parseInt(column) + 1);
            if (flag == 0) {
                panel.setIcon(newIcono);
                matrixWorker.setCellValue(player1.getPiece().equals("X")?1:2);
                flag = 1;

            } else {
                panel.setIcon(newIconx);
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
        }

    }
    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() { return player2; }
    private void newGame(){
        //Reset to default
        matrixWorker.resetArray();
        guiTable.resetTable();
        //guiTable.clearGuiTableDraw();

        win = false;
        winnerName = "";
        flag = 0;


    }

    public static void setPlayer1(String player1Name) {
        player1.setName(player1Name);
    }

    public static void setPlayer2(String player1Name) {
        player2.setName(player1Name);
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


