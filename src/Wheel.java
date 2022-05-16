import java.util.ArrayList;

public class Wheel {
    private ArrayList<Integer> wheel;
    private Board board;
  public Wheel(int size, int diff){

      createWheel(size,diff);
  }
    public void createWheel(int size, int difficulty){
        for (int i = 1; i <= size*size*difficulty;i++){
            wheel.add(i);
        }

    }
    public int generateNumber(){
      return wheel.remove((int)Math.random()*wheel.size()+1);
    }

}
