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

public void printBoard(){
    board.printBoard();
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

    public Wheel getWheel() {
        return wheel;
    }
}
