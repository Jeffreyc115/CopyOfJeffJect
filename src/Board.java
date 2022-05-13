import java.util.Arrays;

public class Board {
    private String username;
    private int[][] board;
    private int[][] oBoard;
    private int wins;
    private int size;
    public Board (int size, String name){
        board = new int[size][size];
        this.size=size;
        for(int r = 0;r<size;r++)
        {
            for(int c = 0;c < size;c++)
            {
                board[r][c] = ((r-1) * 5) + (c+1);
                oBoard[r][c] = ((r-1) * 5) + (c+1);
            }
        }
        username = name;
    }

    public boolean changePoint(int r,int c){
        board[r][c] = 0;
        return (checkWins() > 0);
    }
    private int checkWins(){
        boolean prev = true;
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board.length; c++){
                if (board[r][c] > 0) prev = false;

            }
        }
        if (prev == true) wins++;
        prev = true;
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board.length; c++){
                if (board[c][r] > 0) prev = false;

            }
        }
        if (prev == true) wins++;
        if (size % 2 == 1){
            for (int i = 0; i < size;i++){
                if (board[i][i] != 0)prev = false;
            }
            if (prev == true)wins++;
            for (int i = 0; i < size;i++){
                if (board[i][size-1] != 0) prev = false;
            }
            if (prev == true) wins++;
        }
        return wins;
    }
    public int getWins (){
        return wins;
    }
    public int[][] getBoard(){
        return board;
    }

    public int[][] getoBoard() {
        return oBoard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSize() {
        return size;
    }

   public void printBoard(){
       System.out.println(Arrays.deepToString(board));
   }
}
