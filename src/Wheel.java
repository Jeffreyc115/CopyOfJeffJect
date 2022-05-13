import java.util.ArrayList;

public class Wheel {
    private ArrayList<Integer> wheel;
    private Board board;
  public Wheel(int size){
      createWheel(size);
  }
    public void createWheel(int size){
        for (int i = 1; i <= size*size*2;i++){
            wheel.add(i);
        }

    }
    public int generateNumber(){
      return wheel.remove((int)Math.random()*wheel.size()+1);
    }
}
