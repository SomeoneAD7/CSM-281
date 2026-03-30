import java.util.*;

public class SlotMachineSim {
    public static void main(String[] args){
        Scanner myInput = new Scanner(System.in);
        Random rand = new Random(); 

        String[] slot = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"}; 
        boolean will_play = true; 
        double totalAmountBet = 0; 
        double amountWon = 0; 
        double totalAmountWon = 0;

        while(will_play){
            System.out.print("Welcome to the slot machine! Please enter the amount you want to bet: ");
            double amount = myInput.nextDouble();  
            totalAmountBet += amount; 

            int slot1 = rand.nextInt(6); 
            int slot2 = rand.nextInt(6);
            int slot3 = rand.nextInt(6); 

            System.out.println("The slot machine shows: " + slot[slot1] + " | " + slot[slot2] + " | " + slot[slot3]); 

            if(slot1 == slot2 && slot2 == slot3){ // the three words match
                amountWon = amount * 3;
                System.out.println("Congratulations! You won $" + (amountWon));
            }
            else if(slot1 == slot2 || slot2 == slot3 || slot1 == slot3){ // any two of the words match 
                amountWon = amount * 2;
                System.out.println("Congratulations! You won $" + (amountWon));
            }
            else{ // none of the words match 
                System.out.println("Sorry, you lost your bet of $" + amount);
            }  

            totalAmountWon += amountWon; 

            System.out.print("Do you want to play again? (yes/no): ");
            myInput.nextLine(); // clear buffer 
            String play_again = myInput.nextLine(); 

            if(play_again.equalsIgnoreCase("no")){
                System.out.println("Thanks for playing! \nYou bet a total of $" + totalAmountBet + " and won a total of $" + totalAmountWon);
                will_play = false;
            } 
            else if(play_again.equalsIgnoreCase("yes")){
                will_play = true; 
            } 
            else{
                System.out.println("Invalid choice! "); 
                will_play = false; 
            }
        }
    }
}
