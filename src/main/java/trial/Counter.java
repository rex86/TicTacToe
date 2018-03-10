package trial;

public class Counter {
    int [][] ticTacToeMatrix;
    String piece;
    MatrixWorker matrixWorker;
    Player player;

    int playerNumberInMatrix = 0;
    public Counter(MatrixWorker matrixWorker, Player player){
        this.matrixWorker = matrixWorker;
        this.ticTacToeMatrix = matrixWorker.getTicTacToeMatrix();
        this.player = player;
        playerNumberInMatrix = (player.getPiece()).equals("X")?1:2;
    }

    public int count(String direction){
        //TODO add more direction, diagonal
        int numberOfDot=0;
        switch (direction){
            case "row":
                numberOfDot = countRow();
                break;
            case "column":
                numberOfDot = countColumn();
                break;
            case "diagonalUp":
                numberOfDot = countDiagonalUp();
                break;
            case "diagonalDown":
                numberOfDot = countDiagonalDown();
                break;

        }
        return numberOfDot;
    }

    private int countDiagonalDown() {
        int numberOfDot = 0;
        int row = matrixWorker.getRow();
        int column = matrixWorker.getColumn();

        while(matrixWorker.hasNextStep("rightDown") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("rightDown");
        }
        matrixWorker.setPosition(row + 1,column + 1);
        numberOfDot--;

        while(matrixWorker.hasNextStep("leftUp") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("leftUp");
        }
        return numberOfDot;
    }

    private int countDiagonalUp() {
        int numberOfDot = 0;
        int row = matrixWorker.getRow();
        int column = matrixWorker.getColumn();

        while(matrixWorker.hasNextStep("rightUp") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("rightUp");
        }
        matrixWorker.setPosition(row + 1,column + 1);
        numberOfDot--;
        while(matrixWorker.hasNextStep("leftDown") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("leftDown");
        }
        return numberOfDot;
    }

    private int countColumn() {
        int numberOfDot = 0;
        int row = matrixWorker.getRow();
        int column = matrixWorker.getColumn();

        while(matrixWorker.hasNextStep("up") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("up");
        }
        matrixWorker.setPosition(row + 1,column + 1);
        numberOfDot--;

        while(matrixWorker.hasNextStep("down") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("down");
        }
        return numberOfDot;
    }

    private int countRow() {
        int numberOfDot = 0;
        int row = matrixWorker.getRow();
        int column = matrixWorker.getColumn();

        while(matrixWorker.hasNextStep("right") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("right");
        }
        matrixWorker.setPosition(row + 1,column + 1);
        numberOfDot--;

        while(matrixWorker.hasNextStep("left") && matrixWorker.getCellValue() == playerNumberInMatrix){
            numberOfDot++;
            matrixWorker.move("left");
        }
        return numberOfDot;
    }

    public void setPiece(String piece){
        this.piece = piece;
    }
}
