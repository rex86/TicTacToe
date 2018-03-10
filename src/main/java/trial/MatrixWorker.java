package trial;

public class MatrixWorker {

    //WHAT I SEE!!!
    //So, I rewrite all the method which works array because of array index (start 0 but i see 1,2...etc row,column
    //for example getCellValue(1,2) return the ticTacToeMatrix[0][1]

    private int row,column;
    private int[][] ticTacToeMatrix;
    int freeCellNumber;

    public MatrixWorker(int [][] ticTacToeMatrix){
        this.ticTacToeMatrix = ticTacToeMatrix;
        this.freeCellNumber = ticTacToeMatrix.length * ticTacToeMatrix[0].length;

    }

    //############ GETTER ###########
    public int getCellValue(){
        int rentunValue;
        //TODO add if because of bad index
        //WHAT I see, in this case i have to decrease
        return ticTacToeMatrix[this.row][this.column];
    }

    public int[][] getTicTacToeMatrix(){
        return ticTacToeMatrix;
    }



    //############## SETTER #########
    public void setCellValue(int value){
        //WHAT I see, in this case i have to decrease
        ticTacToeMatrix[row][column] = value;
        freeCellNumber--;
    }

    public void setPosition(int row, int column){
        this.row = row - 1;
        this.column = column - 1;

    }


    //############# METHOD ##########

    public void move(String direction){
        switch (direction){
            case "up":
                moveUp();
                break;
            case "down":
                moveDown();
                break;
            case "right":
                moveRight();
                break;
            case "left":
                moveLeft();
                break;
            case "leftUp":
                moveLeftUp();
                break;
            case "leftDown":
                moveLeftDown();
                break;
            case "rightUp":
                moveRightUp();
                break;
            case "rightDown":
                moveRightDown();
                break;
        }
    }

    private void moveRightDown() {
        move("right");
        move("down");
    }

    private void moveRightUp() {
        move("right");
        move("up");
    }


    private void moveLeftDown() {
        move("left");
        move("down");
    }

    private void moveLeftUp() {
        move("left");
        move("up");
    }

    private void moveLeft() {column-=1; }

    private void moveRight() {column+=1; }

    private void moveDown() {row+=1; }

    private void moveUp() {row-=1; }

    public boolean hasFreeCell(){
        return (this.freeCellNumber > 0)?true:false;
    }

    public boolean hasNextStep(String direction){
        boolean value = false;
        switch (direction){
            case "upDown":
                value = row != 0 && row != ticTacToeMatrix.length - 1;
                break;
            case "leftRight":
                value = column != 0 && column != ticTacToeMatrix[0].length - 1;
        }
        return value;


    }

    @Override
    public String toString() {
        return "MatrixWorker{" +
                "row=" + this.row +
                ", column=" + this.column +
                ", freeCellNumber=" + freeCellNumber +
                '}';
    }
}
