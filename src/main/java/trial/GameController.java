package trial;

import java.util.Scanner;

public class GameController {
    static Counter counter = null;

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
        counter = new Counter(matrixWorker, player1);
        Table table = new Table(matrixWorker);

        Scanner sc = new Scanner(System.in);
        int matrix1, matrix2;
        int flag = 0;
        boolean win = false;
        while (matrixWorker.freeCellNumber > 0 && !win) {

            table.drawTable();

            if (flag == 0) {
                System.out.print("Player 1, matrix of x and y: ");
                matrix1 = sc.nextInt();
                matrix2 = sc.nextInt();
                matrixWorker.setPosition(matrix1, matrix2);
                matrixWorker.setCellValue(1);
                //numbers[matrix1][matrix2] = 1; // XorO, X=1,O=2
                flag = 1;
            } else {
                System.out.print("Player 2, matrix of x and y: ");
                matrix1 = sc.nextInt();
                matrix2 = sc.nextInt();
                matrixWorker.setPosition(matrix1, matrix2);
                matrixWorker.setCellValue(2);

                flag = 0;
            }

            win = isWin();
        }
        table.drawTable();
        System.out.println("End of Game");



        /*
        matrixWorker.setPosition(1,1);
        System.out.println(counter.count("row"));
        matrixWorker.setPosition(1,2);
        System.out.println(counter.count("row"));
        matrixWorker.setPosition(2,2);
        System.out.println(counter.count("row"));
        matrixWorker.setPosition(2,3);
        System.out.println(counter.count("row"));
        matrixWorker.setPosition(3,1);
        System.out.println(counter.count("row"));
        matrixWorker.setPosition(3,2);
        System.out.println(counter.count("row"));
        matrixWorker.setPosition(3,3);
        System.out.println(counter.count("row"));
*/
        /*
        matrixWorker.setPosition(1,1);
        System.out.println(counter.count("column"));
        matrixWorker.setPosition(1,2);
        System.out.println(counter.count("column"));
        matrixWorker.setPosition(2,2);
        System.out.println(counter.count("column"));
        matrixWorker.setPosition(2,3);
        System.out.println(counter.count("column"));
        matrixWorker.setPosition(3,1);
        System.out.println(counter.count("column"));
        matrixWorker.setPosition(3,2);
        System.out.println(counter.count("column"));
        matrixWorker.setPosition(3,3);
        System.out.println(counter.count("column"));
*/
        /*
        matrixWorker.setPosition(1,1);
        System.out.println(counter.count("diagonalUp"));
        matrixWorker.setPosition(1,2);
        System.out.println(counter.count("diagonalUp"));
        matrixWorker.setPosition(2,2);
        System.out.println(counter.count("diagonalUp"));
        matrixWorker.setPosition(2,3);
        System.out.println(counter.count("diagonalUp"));
        matrixWorker.setPosition(3,1);
        System.out.println(counter.count("diagonalUp"));
        matrixWorker.setPosition(3,2);
        System.out.println(counter.count("diagonalUp"));
        matrixWorker.setPosition(3,3);
        System.out.println(counter.count("diagonalUp"));
*/
/*
        matrixWorker.setPosition(1,1);
        System.out.println(counter.count("diagonalDown"));
        matrixWorker.setPosition(1,2);
        System.out.println(counter.count("diagonalDown"));
        matrixWorker.setPosition(2,2);
        System.out.println(counter.count("diagonalDown"));
        matrixWorker.setPosition(2,3);
        System.out.println(counter.count("diagonalDown"));
        matrixWorker.setPosition(3,1);
        System.out.println(counter.count("diagonalDown"));
        matrixWorker.setPosition(3,2);
        System.out.println(counter.count("diagonalDown"));
        matrixWorker.setPosition(3,3);
        System.out.println(counter.count("diagonalDown"));
        */
    }
    static boolean isWin() {
        return counter.count("row") == 3 ||
                counter.count("column") == 3 ||
                counter.count("diagonalUp") == 3 ||
                counter.count("diagonalDown") == 3;
    }
}


