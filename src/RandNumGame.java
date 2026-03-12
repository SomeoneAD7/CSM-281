import java.util.*; 

public class RandNumGame {
    public static void main(String[] args){
        Scanner myinput = new Scanner(System.in); 
        Random rand = new Random(); 

        int randNum = rand.nextInt(100) + 1; // (0-99) + 1 = (1-100) 
        int userGuessCount = 0; 

        System.out.print("Welcome to the Random Number Game! Guess a number between 1 and 100 : ");
        int userGuess = myinput.nextInt();  

        while(userGuess != randNum){
            userGuessCount++; 
            if (userGuess > randNum){
                System.out.println("Too high, Try again. : ");
                userGuess = myinput.nextInt(); 
            }
            else if (userGuess < randNum){
                System.out.println("Too low, Try again. : ");
                userGuess = myinput.nextInt();
            }
        }
        System.out.println("Congratulations! You guessed the number!"); 
        System.out.println("You guessed " + userGuessCount + " times!"); 
    }
}
