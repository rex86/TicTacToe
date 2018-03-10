package trial;

import java.util.Scanner;

public class GameController {
    static Counter counterPlayer1,counterPlayer2 = null;

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
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

        int[][] ticTacToeMatrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},

        };

        MatrixWorker matrixWorker = new MatrixWorker(ticTacToeMatrix);
        Player player1 = new Player("Rex", "X");
        Player player2 = new Player("Moni", "O");
        counterPlayer1 = new Counter(matrixWorker, player1);
        counterPlayer2 = new Counter(matrixWorker, player2);
        Table table = new Table(matrixWorker);
        int player1NumberInMatrix = player1.getPiece().equals("X")?1:2;
        int player2NumberInMatrix = player2.getPiece().equals("X")?1:2;
        Scanner sc = new Scanner(System.in);
        int matrix1, matrix2;
        int flag = 0;
        boolean win = false;
        String winnerName = "";
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

    }
    static boolean isWin(Counter counter) {

        return  counter.count("row") >= 3 ||
                counter.count("column") >= 3 ||
                counter.count("diagonalUp") >= 3 ||
                counter.count("diagonalDown") >= 3;
    }
}


