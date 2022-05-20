public class Player {
    private String name;
    private int wins;

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public Player(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }

    @Override
    public String toString() {
        return name + " " + wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
