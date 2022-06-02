
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
                    checkWins();
                    return true;
                }
            }
        }
        return (checkWins() > 0);
    }
    private int checkWins(){
        boolean prev = false;
        for (int r = 0; r < board.length; r++){
            if (prev == true) wins++;
            prev = true;
            for (int c = 0; c < board.length; c++){
                if (board[r][c] > 0) prev = false;

            }
        }
        if (prev == true) wins++;
        prev = false;
        for (int r = 0; r < board.length; r++){
            if (prev == true) wins++;
            prev = true;
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
            prev = true;
            for (int i = 0; i < size;i++){
                if (board[i][size-1] != 0) prev = false;
            }
            if (prev == true) wins++;
        }
        return wins;
    }
    public void printBoard(){

        for (int[] a:board) {
            for (int x : a) {
                if (x / 10 == 0) {
                    System.out.print(" " + x + "  ");
                }
                else if(x/100 == 0)
                    System.out.print(" " + x + " ");
                else System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public int getWins (){
        return wins;
    }




}
