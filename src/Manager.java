import java.util.Scanner;
public class Manager {
    String name;
    int wins;
    int bS;
    Board Board;
    int diff;
    // bS = Board Size
    Wheel wheel;
    int spins = 0;
public Manager (String name, int wins, int bS, int diff){
    this.name=name;
    this.wins=wins;
    this.bS = bS;
    this.diff = diff;

}
public void createBoard(){
    Board = new Board(bS);
   wheel = new Wheel(bS,diff);
}
public boolean spinWheel(Board Board){
    int ret = wheel.generateNumber();
    spins++;
    if (Board.checkPoint(ret)){
        Board.changePoint(ret);
        wins = Board.getWins();
        return true;
    }
    return false;
}
public void printWins(){
    System.out.println("You have " + wins + "Bingos on this board! Congratulations! it took you " + spins +"!");
}
public void printBoard(){
    System.out.println(Board);
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
