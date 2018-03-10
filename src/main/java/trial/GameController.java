package trial;

public class GameController {
    public static void main(String[] args) {
        runGame();
    }

    public static void runGame(){
        int[][] ticTacToeMatrixTest = {
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
        matrixWorker.setPosition(1,1);
        System.out.println(matrixWorker.getCellValue());
        matrixWorker.move("down");
        System.out.println(matrixWorker.getCellValue());
        matrixWorker.move("down");
        System.out.println(matrixWorker.getCellValue());

    }
}
