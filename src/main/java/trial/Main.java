package trial;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
/*
        System.out.println("+---+---+---+");
        System.out.println("| X |   | O |");
        System.out.println("+---+---+---+");
        System.out.println("| X | O |   |");
        System.out.println("+---+---+---+");
        System.out.println("| X |   |   |");
        System.out.println("+---+---+---+");

0 - empty
1 - X
2 - O
 */

        int[][] numbers = {
                {1, 0, 1},
                {0, 0, 1},
                {0, 1, 2},

        };
        /*
        int[][] numbers = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},

        };*/

        boolean isTableFull = isTableFull(numbers);
        boolean isWin = false;
        Scanner sc = new Scanner(System.in);
        int matrix1,matrix2;
        int flag=0;
/*
        while(!isWin && !isTableFull){

            writeAChar(numbers);

            if(flag == 0){
                System.out.print("Player 1, matrix of x and y: ");
                matrix1 = sc.nextInt();
                matrix2 = sc.nextInt();
                numbers[matrix1][matrix2] = 1; // XorO, X=1,O=2
                flag = 1;
            }else{
                System.out.print("Player 2, matrix of x and y: ");
                matrix1 = sc.nextInt();
                matrix2 = sc.nextInt();
                numbers[matrix1][matrix2] = 2;
                flag = 0;
            }

            isWin = isWin(numbers,matrix1,matrix2);
            isTableFull = isTableFull(numbers);
            System.out.println(isWin);
            System.out.println(isTableFull);

        }*/
        //writeAChar(numbers);
        //isWin(numbers,1,2);
        //System.out.println("End of Game");


//######### TEST #############
//if arrayName[x][y] == 0 return -1
/*
        writeAChar(numbers);

        System.out.println("############countDotInRowDiagonalDown############");
        System.out.println(countDotInRowDiagonalDown(numbers,0,1));
        System.out.println(countDotInRowDiagonalDown(numbers,0,2));
        System.out.println(countDotInRowDiagonalDown(numbers,1,0));
        System.out.println(countDotInRowDiagonalDown(numbers,1,1));
        System.out.println(countDotInRowDiagonalDown(numbers,2,0));
        System.out.println(countDotInRowDiagonalDown(numbers,2,1));
        System.out.println(countDotInRowDiagonalDown(numbers,2,2));

        System.out.println("############countDotInDiagonalUp############");
        System.out.println(countDotInDiagonalUp(numbers,0,1));
        System.out.println(countDotInDiagonalUp(numbers,0,2));
        System.out.println(countDotInDiagonalUp(numbers,1,0));
        System.out.println(countDotInDiagonalUp(numbers,1,1));
        System.out.println(countDotInDiagonalUp(numbers,2,0));
        System.out.println(countDotInDiagonalUp(numbers,2,1));
        System.out.println(countDotInDiagonalUp(numbers,2,2));

        System.out.println("############countDotIncolumn############");
        System.out.println(countDotIncolumn(numbers,0,1));
        System.out.println(countDotIncolumn(numbers,0,2));
        System.out.println(countDotIncolumn(numbers,1,0));
        System.out.println(countDotIncolumn(numbers,1,1));
        System.out.println(countDotIncolumn(numbers,2,0));
        System.out.println(countDotIncolumn(numbers,2,1));
        System.out.println(countDotIncolumn(numbers,2,2));

        System.out.println("############countDotInRow############");

        System.out.println(countDotInRow(numbers, 0, 1));
        System.out.println(countDotInRow(numbers, 0, 2));
        System.out.println(countDotInRow(numbers, 1, 0));
        System.out.println(countDotInRow(numbers, 1, 1));
        System.out.println(countDotInRow(numbers, 2, 0));
        System.out.println(countDotInRow(numbers, 2, 1));
        System.out.println(countDotInRow(numbers, 2, 2));
*/
        System.out.println("############countDotIncolumn############");

        System.out.println(countDotIncolumn(numbers,0,2));


    }

    static void drawTable(int row, int col, int[][] elhelyezes, String XorY) {
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                System.out.println("+---");
                XorY = (!XorY.equals("")) ? XorY : "";
                System.out.println("| " + XorY + " |");
            }
        }
    }

    static void printArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void drawheader(int widthNumber, int cellNumber) {
        System.out.print("+");
        for (int i = 0; i < cellNumber; i++) {
            for (int j = 0; j < widthNumber; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    static void writeAChar(int[][] numbers) {
        String writeableChar = "";
        for (int i = 0; i < numbers.length; i++) {
            drawheader(3, 3);
            for (int j = 0; j < numbers[0].length; j++) {
                switch (numbers[i][j]) {
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
        drawheader(3, 3);
    }

    static boolean isWin(int[][] workArray, int startX, int startY) {

        /*System.out.println(countDotInRow(workArray,startX,startY));
        System.out.println(countDotIncolumn(workArray,startX,startY));
        System.out.println(countDotInDiagonalUp(workArray,startX,startY));
        System.out.println(countDotInRowDiagonalDown(workArray,startX,startY));*/
        return countDotInRow(workArray,startX,startY) == 3 ||
                countDotIncolumn(workArray,startX,startY) == 3 ||
                countDotInDiagonalUp(workArray,startX,startY) == 3 ||
                countDotInRowDiagonalDown(workArray,startX,startY) == 3;


    }

    //We take a step from this point (workArray[x][y]) to right/left/up/down.
    //When we reached te edge of array whe go back the opposite direction from the array[x][y] position.

    //TODO:rewrite all the method because i assume that there are only 0/1 in the array...getValueInArray is wrong condition to increase dots variable

    //Sor
    public static int countDotInRow(int[][] workArray, int startX, int startY) {
        //startX means: starting point in the array

        int numberOfDot = 0,  pattern, getValueInArray;
        pattern = 1;
        CheckArrayEdge arrayEdge = new CheckArrayEdge(workArray);
        arrayEdge.setPosition(startX, startY);
        boolean hasNext = false;

        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextStepRight(arrayEdge.getYPosition());

        while (pattern == getValueInArray && hasNext) {

            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            arrayEdge.setNewYPositionDown();
            hasNext = arrayEdge.hasNextStepRight(arrayEdge.getYPosition());

            if (getValueInArray != 0) numberOfDot++;


        }

        //####################### II. part ############

        numberOfDot--; //we don't have to count dots again, starting points is same as above
        arrayEdge.setPosition(startX, startY);
        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextStepLeft(arrayEdge.getYPosition());

        while (pattern == getValueInArray && hasNext ) {

            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            arrayEdge.setNewYPositionUp();
            hasNext = arrayEdge.hasNextStepLeft(arrayEdge.getYPosition());

            if (getValueInArray != 0) numberOfDot++;
        }

        return numberOfDot;

    }

    //oszlop
    public static int countDotIncolumn(int[][] workArray, int startX, int startY) {
        int numberOfDot = 0,  pattern, getValueInArray;
        pattern = 1;
        CheckArrayEdge arrayEdge = new CheckArrayEdge(workArray);
        arrayEdge.setPosition(startX, startY);
        boolean hasNext = false;

        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextStepDown(arrayEdge.getXPosition());

        while (pattern == getValueInArray && hasNext) {

            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            arrayEdge.setNewXPositionDown();
            hasNext = arrayEdge.hasNextStepDown(arrayEdge.getXPosition());
            System.out.println("FIRST PART: " + arrayEdge.getXPosition() + " : " + arrayEdge.getYPosition());
            System.out.println("value: " + getValueInArray);
            if (getValueInArray != 0) numberOfDot++;


        }
        System.out.println("DOTS I: " + numberOfDot);
        //####################### II. part ############
        System.out.println("PART II");
        numberOfDot--; //we don't have to count dots again, starting points is same as above
        arrayEdge.setPosition(startX, startY);
        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextStepUp(arrayEdge.getYPosition());

        while (pattern == getValueInArray && hasNext ) {

            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            System.out.println("beforup: " + arrayEdge.getXPosition() + " : " + arrayEdge.getYPosition());
            arrayEdge.setNewYPositionUp();
            hasNext = arrayEdge.hasNextStepUp(arrayEdge.getXPosition());
            System.out.println(arrayEdge.getXPosition() + " : " + arrayEdge.getYPosition());
            //System.out.println("value: " + getValueInArray);
            if (getValueInArray != 0) numberOfDot++;
        }
        return numberOfDot;

    }

    //átló1
    public static int countDotInDiagonalUp(int[][] workArray, int startX, int startY) {

        int numberOfDot = 0, pattern, getValueInArray;
        pattern = 1;
        CheckArrayEdge arrayEdge = new CheckArrayEdge(workArray);
        arrayEdge.setPosition(startX, startY);
        boolean hasNext = false;

        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextRightUp(arrayEdge.getXPosition(), arrayEdge.getYPosition());

        while (pattern == getValueInArray && hasNext) {
            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            arrayEdge.setNewPositionRightUp();
            hasNext = arrayEdge.hasNextRightUp(arrayEdge.getXPosition(), arrayEdge.getYPosition());

            if (getValueInArray != 0) numberOfDot++;

        }

        //####################### II. part ############

        numberOfDot--; //we don't have to count dots again, starting points is same as above
        arrayEdge.setPosition(startX, startY);
        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextDownLeft(arrayEdge.getXPosition(), arrayEdge.getYPosition());

        while (pattern == getValueInArray && hasNext) {

            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            arrayEdge.setNewPositionDownLeft();
            hasNext = arrayEdge.hasNextDownLeft(arrayEdge.getXPosition(), arrayEdge.getYPosition());

            if (getValueInArray != 0) numberOfDot++;

        }
        return numberOfDot;

    }

    //átló2
    public static int countDotInRowDiagonalDown(int[][] workArray, int startX, int startY) {

        int numberOfDot = 0, pattern, getValueInArray;
        pattern = 1;
        CheckArrayEdge arrayEdge = new CheckArrayEdge(workArray);
        arrayEdge.setPosition(startX, startY);
        boolean hasNext = false;

        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextDownRight(arrayEdge.getXPosition(), arrayEdge.getYPosition());

        while (pattern == getValueInArray && hasNext) {
            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            arrayEdge.setNewPositionDownRight();
            hasNext = arrayEdge.hasNextDownRight(arrayEdge.getXPosition(), arrayEdge.getYPosition());
            //WÁÁÁÁÁÁÁÁ pain...
            if (getValueInArray != 0) numberOfDot++;

        }
        //####################### II. part ############

        numberOfDot--; //we don't have to count dots again, starting points is same as above
        arrayEdge.setPosition(startX, startY);
        getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
        hasNext = arrayEdge.hasNextLeftUp(arrayEdge.getXPosition(), arrayEdge.getYPosition());

        while (pattern == getValueInArray && hasNext) {

            getValueInArray = workArray[arrayEdge.getXPosition()][arrayEdge.getYPosition()];
            arrayEdge.setNewPositionLeftUp();
            hasNext = arrayEdge.hasNextLeftUp(arrayEdge.getXPosition(), arrayEdge.getYPosition());

            if (getValueInArray != 0) numberOfDot++;

        }
        return numberOfDot;
    }

    public static boolean isTableFull(int[][] workArray){
        boolean isFull=true;
        for (int i = 0; i < workArray.length; i++) {
            for (int j = 0; j < workArray[0].length; j++) {
                if(workArray[i][j] == 0){
                    isFull = false;
                    break;

                }

            }
        }

        return isFull;
    }

}

