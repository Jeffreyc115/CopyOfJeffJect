import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {

        String name = "";
        ArrayList<Player> playerList= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {// reads from file
            String filePath = "src/users";
            Scanner fileRead = new Scanner(new File(filePath));
            while (fileRead.hasNext()) {
                String temp = fileRead.nextLine();
                String[] tArray = temp.split(";;");
                playerList.add(new Player(tArray[0],Integer.parseInt(tArray[1])));
            }
            fileRead.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size = 0;
        boolean one = false;
        int diff = 0;
        int totalWins = 0;
        String para = "";
        System.out.println("Are you an existing user or a new user? \n \"e\" for existing user : \n \"n\" for a new user : ");
        String option = sc.nextLine();
        while (option != "e" || option!= "n") {
            if (option.equals("e")) {
                for (int i = 0; i < playerList.size(); i++) {
                    System.out.println((i + 1) + ". " + playerList.get(i).toString());
                }
                System.out.println("Which user do you want?");
                int number = Integer.parseInt(sc.nextLine()) - 1;
                int wins = playerList.get(number).getWins();
                name = playerList.get(number).getName();


            } else if (option.equals("n")) {
                while (!(name.length() > 0)) {
                    if ((!one)) System.out.println("Enter your name: ");
                    else System.out.println("Please enter a valid Name of Length greater than 1. :");
                    name = sc.nextLine();
                    one = true;
                    playerList.add(new Player(name, 0));
                }
            }
        }
        while (size <= 3 || size > 15) {
            System.out.println("Enter the Dimensions of your Bingo Board." + para);
            size = Integer.parseInt(sc.nextLine());
            para = "(Lowest number is 3 and highest number is 15)";
        }
        System.out.println("Enter a difficulty level between 1 and 3 :");
        diff = Integer.parseInt(sc.nextLine());
        while (!(diff > 0 && diff < 4)) {
            System.out.println("Please enter a valid number between 1 and 3 : ");
            diff = Integer.parseInt(sc.nextLine());
        }
        Manager roller = new Manager(name, size, diff);
        roller.createBoard();

//Code for later
        String input;
        boolean wantsToPlay = true;
        if (wantsToPlay) {
            System.out.println("Welcome back " + "! You currently have " + totalWins + " Wins! Would you like to keep playing or quit?");
            input = "";
            while (true) {
                System.out.println("Type \"p\" if you want to keep playing : ");
                System.out.println("Type \"q\" if you want to quit : ");
                System.out.println(input);
                input = sc.nextLine();
                if (input.equals("q")) {
                    File file = new File("src/users");
                    try {
                        FileWriter writer = new FileWriter(file);
                        for (Player x :playerList){
                            writer.write(x.getName() + ";;" + x.getWins());
                        }
                        writer.close();
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (input.equals("p")) {
                if (roller.spinWheel(roller.getBoard())){
                    System.out.println("You got the number " + roller.getNum() + "! It is going to be marked on your borad!");
                    roller.printBoard();
                    roller.setNum(0);
                }
                else{
                    System.out.println("Your board didn't have the number " + roller.getNum() + ". Your board didn't change. ");
                    }


                }
            }
        }
    }
}

