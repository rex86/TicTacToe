package trial;

public class CheckArrayEdge {

    int[][] array;
    int arrayLength;
    int arrayElementLength;
    int xPosition,yPosition;


    public CheckArrayEdge(int[][] arrayToCheck) {
        this.array = arrayToCheck;
        this.arrayLength = array.length;
        this.arrayElementLength = array[0].length;


    }

    public boolean hasNextStepRight(int yPosition){
        return yPosition < arrayElementLength;
    }
    public boolean hasNextStepLeft(int yPosition){

        return yPosition >= 0;
    }
    public boolean hasNextStepUp(int xPosition){return xPosition >= 0;}
    public boolean hasNextStepDown(int xPosition){return xPosition < arrayElementLength;}
    public boolean hasNextRightUp(int xPosition, int yPosition){

        return hasNextStepUp(xPosition) && hasNextStepRight(yPosition);
    }
    public boolean hasNextDownLeft(int xPosition, int yPosition){
        return hasNextStepDown(xPosition) && hasNextStepLeft(yPosition);
    }
    public boolean hasNextDownRight(int xPosition, int yPosition){
        return hasNextStepDown(xPosition) && hasNextStepRight(yPosition);
    }
    public boolean hasNextLeftUp(int xPosition, int yPosition){
        return hasNextStepLeft(xPosition) && hasNextStepUp(yPosition);
    }

    //SETTER and GETTER

    public int getXPosition() {
        return xPosition;
    }
    public int getYPosition() {
        return yPosition;
    }
    public void setPosition(int xPosition,int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    //SET new position

    public void setNewXPositionUp() {
        this.xPosition = xPosition-1;
    }
    public void setNewYPositionUp() {
        this.yPosition = yPosition-1;
    }
    public void setNewXPositionDown() {this.xPosition = xPosition+1;}
    public void setNewYPositionDown() {
        this.yPosition = yPosition+1;
    }
    public void setNewPositionRightUp(){
        setNewXPositionUp();
        setNewYPositionDown();
    }
    public void setNewPositionDownLeft(){
        setNewXPositionDown();
        setNewYPositionUp();
    }
    public void setNewPositionDownRight(){
        setNewXPositionDown();
        setNewYPositionDown();
    }
    public void setNewPositionLeftUp(){
        setNewXPositionUp();
        setNewYPositionUp();
    }

}
