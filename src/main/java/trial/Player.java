package trial;

public class Player {
    String name;
    String piece;
    public Player(String name, String piece){
        this.name = name;
        this.piece = piece;
    }

    public String getPiece() {
        return piece;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
}
