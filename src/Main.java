import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) {

       /* Scanner sc =  new Scanner(System.in);
        String name= "";
        int size;
        while (!(name.length()>0)){
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter the Dimensions of your Bingo Board.");
        size = sc.nextInt();*/

        try
        {
            String filePath = "src/File";
            Scanner fileRead = new Scanner(new File(filePath));
            if(fileRead.hasNext()) {
                String name = fileRead.nextLine();
            }
            else // NO NAME DEFINED
            {

            }
            if(fileRead.hasNext())
            {
                int win = Integer.parseInt(fileRead.nextLine());
            }
            //System.out.println(name + " " + win);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }




        }




    }

