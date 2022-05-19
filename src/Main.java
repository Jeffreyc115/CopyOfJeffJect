import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) {



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
                Scanner sc =  new Scanner(System.in);
                String name= "";
                int size = 0;
                boolean one = false;
                int diff= 0;
                String para = "";
                while (!(name.length()>0)) {
                    if ((!one))System.out.println("Enter your name: ");
                    else System.out.println("Please enter a valid Name of Length greater than 1. :");
                    name = sc.nextLine();
                    one = true;
                    while (size <=3 || size > 15)
                    System.out.println("Enter the Dimensions of your Bingo Board." + para);
                    size = sc.nextInt();
                    para = "(Lowest number is 3 and highest number is 15)";
                    System.out.println("Enter a difficulty level between 1 and 3 :");
                    diff = sc.nextInt();
                    while (!(diff > 0 && diff < 4)){
                        System.out.println("Please enter a valid number between 1 and 3 : ");
                        diff = sc.nextInt();
                    }
                }

                e.printStackTrace();
            }

//Code for later
        String input;
        if(containsName){
            System.out.println("Welcome back " + "! You currently have " + " Wins! Would you like to keep playing or quit?");
            Scanner sc =  new Scanner(System.in);
            input = sc.nextLine();
                while (input != "p" || input != "q"){
                    System.out.println("Type \"p\" if you want to keep playing : ");
                    System.out.println("Type \"q\" if you want to quit : ");
                    if (input == "q") {
                        //Save file all files
                    }
                    if (input == "p"){

                        Manager roller = new Manager;
                    }
                }
            }

        }


    }

