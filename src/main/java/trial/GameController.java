package trial;

import gui.GuiTable;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GameController {
    Counter counterPlayer1,counterPlayer2 = null;
    int matrix1=1, matrix2=1;
    int flag = 0;
    final int NUMBEROFDOTCOUNT = 5;
    final int TICTACTOEGAMETABLESIZE = 20;

    int[][] ticTacToeMatrix = new int[TICTACTOEGAMETABLESIZE][TICTACTOEGAMETABLESIZE];
    boolean win = false;
    String winnerName = "";
    MatrixWorker matrixWorker = new MatrixWorker(ticTacToeMatrix);
    Player player1 = new Player("Rex", "X");
    Player player2 = new Player("Moni", "O");
    Table table = new Table(matrixWorker);

    GuiTable guiTable = new GuiTable(this,TICTACTOEGAMETABLESIZE);

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

        if(panel.getBackground() != Color.BLUE && panel.getBackground() != Color.RED) {

            //because of xx,yyy,zzzz digits, for example: col 11, row 11...
            stringArrayFromSplit = panel.getName().split("-");
            row = stringArrayFromSplit[0];
            column = stringArrayFromSplit[1];
            matrixWorker.setPosition(Integer.parseInt(row) + 1,Integer.parseInt(column) + 1);

            if (flag == 0) {
                panel.setBackground(Color.BLUE);
                matrixWorker.setCellValue(player1.getPiece().equals("X")?1:2);
                flag = 1;
            } else {
                panel.setBackground(Color.RED);
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


