import java.util.*;

public class RockPaperScissors {
    static String[] choices = {"rock", "paper", "scissors"}; 

    public static String getComputerChoice(Random rand) {
        return choices[rand.nextInt(3)];
    } 

    public static String getUserChoice(Scanner myInput) {
        String choice;
        while (true) {
            System.out.print("Enter your choice (rock, paper, scissors): ");
            choice = myInput.nextLine().trim().toLowerCase();
            if (choice.equals("rock") || choice.equals("paper") || choice.equals("scissors")){
                return choice;
            }
            else{
                System.out.println("  Invalid choice. Please enter rock, paper, or scissors.");
            }
        }
    } 

    public static int determineWinner(String user, String computer) {
        // Returns: 1 = user wins, 2 = computer wins, 0 = tie
        if (user.equals(computer)){
            return 0;
        }

        if ((user.equals("rock") && computer.equals("scissors")) || (user.equals("scissors") && computer.equals("paper")) || (user.equals("paper") && computer.equals("rock"))){
            return 1;
        } 

        else{
            return 2;
        } 
    }

    public static void main(String[] args){
        Scanner myInput = new Scanner(System.in);
        Random rand = new Random(); 
        int result;

        System.out.println("===== Rock, Paper, Scissors Game =====\n");
        do {
            String userChoice     = getUserChoice(myInput);
            String computerChoice = getComputerChoice(rand);

            System.out.println("  Computer chose: " + computerChoice);

            result = determineWinner(userChoice, computerChoice);

            if (result == 1) {
                System.out.println("  You win! (" + userChoice + " beats " + computerChoice + ")\n");
            } 
            else if (result == 2) {
                System.out.println("  Computer wins! (" + computerChoice + " beats " + userChoice + ")\n");
            } 
            else {
                System.out.println("  It's a tie! Playing again to determine a winner...\n");
            }
        } 
        while (result == 0); // The do-while loop is to ensure that the user can play the game at least once.
    }
}
