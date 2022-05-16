import java.util.Scanner;
public class Manager {
    String name;
    int wins;
    int bS;
public Manager (String name, int wins, int bS){
    this.name=name;
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
