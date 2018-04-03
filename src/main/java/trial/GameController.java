package trial;

import gui.GuiTable;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GameController {
    Counter counterPlayer1,counterPlayer2 = null;
    int matrix1=1, matrix2=1;
    int flag = 0;
    final int NUMBEROFDOTCOUNT = 3;
    int[][] ticTacToeMatrix = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},

    };
    boolean win = false;
    String winnerName = "";
    MatrixWorker matrixWorker = new MatrixWorker(ticTacToeMatrix);
    Player player1 = new Player("Rex", "X");
    Player player2 = new Player("Moni", "O");
    Table table = new Table(matrixWorker);
    int player1NumberInMatrix = player1.getPiece().equals("X")?1:2;
    int player2NumberInMatrix = player2.getPiece().equals("X")?1:2;

    GuiTable guiTable = new GuiTable(this);

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
        counterPlayer1 = new Counter(matrixWorker, player1);
        counterPlayer2 = new Counter(matrixWorker, player2);

        if(panel.getBackground() != Color.BLUE && panel.getBackground() != Color.RED) {

            row = panel.getName().substring(0, 1);
            column = panel.getName().substring(1, 2);

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

    public void runGame() {
        int[][] ticTacToeMatrixTest = {
                {1, 1, 2},
                {0, 1, 1},
                {1, 1, 1},

        };
        int[][] ticTacToeMatrixTest2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},

        };








  /*
        boolean win = false;
        String winnerName = "";
        //System.out.println("MATRIX1: " + matrix1);
        //System.out.println("MATRIX2: " + matrix2);

        if (flag == 0) {
            System.out.print(player1.getName() + " row: column: ");

            matrixWorker.setPosition(matrix1, matrix2);
            matrixWorker.setCellValue(player1NumberInMatrix); // XorO, X=1,O=2
            flag = 1;
        } else {
            System.out.print(player2.getName() + " row: column: ");

            matrixWorker.setPosition(matrix1, matrix2);
            matrixWorker.setCellValue(player2NumberInMatrix); // XorO, X=1,O=2

            flag = 0;
        }
        */
        //#### CONSOLE GAME
        /*
        while (matrixWorker.freeCellNumber > 0 && !win) {

            table.drawTable();

            if (flag == 0) {
                System.out.print(player1.getName() + " row: column: ");
                matrix1 = sc.nextInt();
                matrix2 = sc.nextInt();
                matrixWorker.setPosition(matrix1, matrix2);
                matrixWorker.setCellValue(player1NumberInMatrix); // XorO, X=1,O=2
                flag = 1;
            } else {
                System.out.print(player2.getName() + " row: column: ");
                matrix1 = sc.nextInt();
                matrix2 = sc.nextInt();
                matrixWorker.setPosition(matrix1, matrix2);
                matrixWorker.setCellValue(player2NumberInMatrix); // XorO, X=1,O=2

                flag = 0;
            }
            win = isWin(counterPlayer1) || isWin(counterPlayer2);
            if(win && flag == 0){
                winnerName = player2.getName();
            }else if(win && flag == 1){
                winnerName = player1.getName();
            }
            System.out.println();
        }

        table.drawTable();

        if(winnerName.isEmpty()){
            System.out.println("Nobody won because there is no empty cell");
            System.out.println("End of Game");
        }else {
            System.out.println(winnerName + " is won");
            System.out.println("End of Game");
        }
*/
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


