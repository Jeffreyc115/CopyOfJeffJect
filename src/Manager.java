import java.util.Scanner;
public class Manager {
    String name;
    int wins;
    int bS;
    Board board;
    int diff;
    int num;
    // bS = Board Size
    Wheel wheel;
    int spins = 0;

public Manager (String name, int bS, int diff){
    this.name=name;
    this.bS = bS;
    this.diff = diff;

}
public void createBoard(){
    board = new Board(bS);
   wheel = new Wheel(bS,diff);
}
public boolean spinWheel(Board board){
    num = wheel.generateNumber();
    spins++;
    if (board.checkPoint(num)){
        board.changePoint(num);
        wins = board.getWins();
        return true;
    }
    return false;
}
public void printWins(){
    System.out.println("You have " + wins + "Bingos on this board! Congratulations! it took you " + spins +"!");
}
public void printBoard(){
    board.printBoard();
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getbS() {
        return bS;
    }

    public void setbS(int bS) {
        this.bS = bS;
    }

    public Board getBoard() {
        return  board;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getWins() {
        return board.getWins();
    }
}
