package trial;

public class Counter {
    int [][] ticTacToeMatrix;
    String piece;
    MatrixWorker matrixWorker;
    public Counter(MatrixWorker matrixWorker){
        this.matrixWorker = matrixWorker;
         this.ticTacToeMatrix = matrixWorker.getTicTacToeMatrix();
    }

    public int count(String direction){
        //TODO add more direction, diagonal
        switch (direction){
            case "row":
                countRow();
                break;
            case "column":
                countColumn();
                break;

        }
        return 0;
    }

    private void countColumn() {
    }

    private void countRow() {
    }

    public void setPiece(String piece){
        this.piece = piece;
    }
}
