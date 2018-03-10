package trial;

public class GameController {
    public static void main(String[] args) {
        runGame();
    }

    public static void runGame(){
        int[][] ticTacToeMatrixTest = {
                {1, 1, 0},
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

        MatrixWorker matrixWorker = new MatrixWorker(ticTacToeMatrixTest);
        Player player1 = new Player("Rex","X");
        Counter counter = new Counter(matrixWorker,player1);
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
}
