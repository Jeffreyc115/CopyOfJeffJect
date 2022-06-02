import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class BingoPlayer {
    public static void main(String[] args) {

        String name = "";
        String back = "";
        ArrayList<Player> playerList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {// reads from file
            String filePath = "src/users";
            Scanner fileRead = new Scanner(new File(filePath));
            while (fileRead.hasNext()) {
                String temp = fileRead.nextLine();
                String[] tArray = temp.split(";;");
                playerList.add(new Player(tArray[0], Integer.parseInt(tArray[1])));
            }
            fileRead.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size = 0;
        boolean one = false;
        int diff = 0;
        int totalWins = 0;
        String para = "";
        System.out.print("Are you an existing user or a new user? \n \"e\" for existing user  \n \"n\" for a new user \n type here: ");
        String option = "";
        Player player = null;
        while (true) {
            int number = Integer.MAX_VALUE;
            option = sc.nextLine();
            if (option.equals("e")) {
                for (int i = 0; i < playerList.size(); i++) {
                    System.out.println((i + 1) + ". " + playerList.get(i).toString());
                }
                while (number > playerList.size() - 1) {
                    System.out.println("Which user do you want?");
                    try {
                        number = Integer.parseInt(sc.nextLine()) - 1;
                    }
                    catch (NumberFormatException e)
                    {
                        continue;
                    }
                }
                player = playerList.get(number);
                name = playerList.get(number).getName();
                totalWins = playerList.get(number).getWins();
                back = "back";
                break;
            } else if (option.equals("n")) {
                while (!(name.length() > 0)) {
                    if ((!one)) System.out.println("Enter your name: ");
                    else System.out.println("Please enter a valid Name of Length greater than 1. :");
                    name = sc.nextLine();
                    one = true;
                    player = new Player(name, 0);
                    playerList.add(player);
                }
                break;
            }
        }
        while (size < 3 || size > 30) {
            System.out.println("Enter the Dimension of your Bingo Board." + para);
            try {
                size = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e)
            {
                continue;
            }
            para = "(Lowest number is 3 and the highest number is 30)";
        }

       // diff = Integer.parseInt(sc.nextLine());
        while (!(diff > 0 && diff < 11)) {
            System.out.println("Please enter a valid number between 1 and 10 for your difficulty: ");
            try {
                diff = Integer.parseInt(sc.nextLine());

            }
            catch (NumberFormatException e)
            {
                continue;
            }
        }
        Manager roller = new Manager(name, size, diff);
        roller.createBoard();

        String input;

        if (true) {
            System.out.println("Welcome " + back + "! You currently have " + totalWins + " Wins! Would you like to keep playing or quit?");
            input = "";

            while (true) {
                System.out.println("Type \"p\" if you want to keep playing ");
                System.out.println("Type \"q\" if you want to quit ");
                System.out.print("Type your choice here or else  :");
                input = sc.nextLine();
                if (input.equals("q")) {
                   break;
                }
                if (input.equals("p")) {
                    if (roller.spinWheel(roller.getBoard())) {
                        System.out.println("You got the number " + roller.getNum() + "! It is going to be marked on your borad!");
                        roller.printBoard();
                        roller.setNum(0);
                        if (roller.getWins() > 0) {
                            System.out.println("BINGO! You've won " + roller.getWins() + " Time on that board! Great Job!");
                            System.out.println("Congratulations! You've won! You have officially wasted your time playing this game! It only took you " + roller.getWheel().getSpins() + " Spins! ");
                            player.setWins(player.getWins() + roller.getWins());
                            break;
                        }
                    }
                    else {
                        System.out.println("Your board didn't have the number " + roller.getNum() + ". Your board didn't change. ");
                        roller.printBoard();
                    }
                }
            else System.out.println("That's not what you were supposed to type! Type \"p\" or \"q\"");
            }
            File file = new File("src/users");
            try {
                FileWriter writer = new FileWriter(file);
                for (Player x : playerList) {
                    writer.write(x.getName() + ";;" + x.getWins() + System.lineSeparator());
                }
                writer.close();
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
}

