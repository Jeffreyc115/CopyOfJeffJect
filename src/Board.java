
import java.util.Arrays;

public class Board  {

    private int[][] board;
    private int wins;
    private int size;
    public Board (int size){
        board = new int[size][size];
        this.size=size;
        for(int r = 0;r<size;r++)
        {
            for(int c = 0;c < size;c++)
            {
                board[r][c] = (r * size) + (c+1);
            }
        }


    }
    public boolean checkPoint(int check){
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                if (board[r][c] == check){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean changePoint(int check){
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                if (board[r][c] == check){
                    board[r][c] = 0;
                    return true;
                }
            }
        }
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



    public int getSize() {
        return size;
    }

   public void printBoard(){

        for (int[] a:board) {
            for (int x : a)
                System.out.print(x + " ");
            System.out.println();
        }
   }

}
