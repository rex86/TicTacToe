package trial;

public class Table {

    int rowNum = 3,columnNum = 3;
    MatrixWorker matrixWorker;
    public Table(MatrixWorker matrixWorker) {
        this.matrixWorker = matrixWorker;

    }

    public void drawTable(){
        String writeableChar = "";
        for (int i = 0; i < matrixWorker.getTicTacToeMatrix().length; i++) {
            drawheader();
            for (int j = 0; j < matrixWorker.getTicTacToeMatrix()[0].length; j++) {
                switch (matrixWorker.getTicTacToeMatrix()[i][j]) {
                    case 0:
                        writeableChar = " ";
                        break;
                    case 1:
                        writeableChar = "X";
                        break;
                    case 2:
                        writeableChar = "O";
                        break;
                }

                System.out.print("| " + writeableChar + " ");
            }
            System.out.println("|");
        }
        drawheader();
    }

    void drawheader() {
        System.out.print("+");
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }
}
