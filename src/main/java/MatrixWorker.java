public class MatrixWorker {

    //WHAT I SEE!!!
    //So, I rewrite all the method which works array because of array index (start 0 but i see 1,2...etc row,column
    //for example getCellValue(1,2) return the ticTacToeMatrix[0][1]

    private int xPosition,yPosition;
    private int[][] ticTacToeMatrix;


    public MatrixWorker(){


    }

    //############ GETTER ###########
    public int getCellValue(int x, int y){
        int rentunValue;
        //TODO add if because of bad index
        return ticTacToeMatrix[x][y];
    }

    public int[][] getTicTacToeMatrix(){
        return ticTacToeMatrix;
    }



    //############## SETTER #########
    public void setCellValue(int value){
        ticTacToeMatrix[xPosition][yPosition] = value;
    }


    //############# METHOD ##########



}
