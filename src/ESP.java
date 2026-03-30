import java.util.*; 

public class ESP{
    public static void main(String[] args){
        String[] colours = {"Red", "Green", "Blue", "Orange",  "Yellow"}; 
        Scanner myinput = new Scanner(System.in);
        Random rand = new Random();
        int correct = 0; 

        System.out.println("Welcome to the ESP Game!");
        
        for(int i = 1; i <= 10; i++){
            int randNum = rand.nextInt(5);  // (0-4) 

            System.out.print("Guess the colour : "); 
            String userGuess = myinput.nextLine(); 

            if (userGuess.equalsIgnoreCase(colours[randNum])){
                correct++; 
                System.out.println("You guessed correctly!"); 
                System.out.println("The correct colour was " + colours[randNum] + "."); 
            } 
            else{
                System.out.println("Wrong!"); 
                System.out.println("The correct colour was " + colours[randNum] + "."); 
            }  
            
            System.out.println(); 
        } 

        System.out.println("You guessed the right colour " + correct + " times."); 
    }
}