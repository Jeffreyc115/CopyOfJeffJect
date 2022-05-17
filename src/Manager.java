import java.util.Scanner;
public class Manager {
    String name;
    int wins;
    int bS;
    Board Board;
    int diff;
    // bS = Board Size
    Wheel wheel;
public Manager (String name, int wins, int bS, int diff){
    this.name=name;
    this.wins=wins;
    this.bS = bS;
    this.diff = diff;

}
public void createBoard(int bS,int diff){
    Board = new Board(bS);
   wheel = Wheel(bS,diff)
}
public boolean spinWheel(Board Board){

}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getbS() {
        return bS;
    }

    public void setbS(int bS) {
        this.bS = bS;
    }
}
