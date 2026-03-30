import java.util.Random; 

public class DiceGame{
    public static void main(String[] args){
        Random rand = new Random(); 
        int comp_wins = 0; 
        int user_wins = 0; 

        for(int i = 1; i <= 10; i++){
            int comp_die = rand.nextInt(7); 
            int user_die = rand.nextInt(7); 

            if(comp_die > user_die){
                comp_wins++;
            }
            else if(comp_die == user_die){
                // its a tie so do nothing 
            } 
            else if(user_die > comp_die){
                user_wins++; 
            } 
            
        } 

        if(comp_wins > user_wins){
            System.out.println("The winner of this game is the computer.");
        }
        else{
            System.out.println("The winner of this game is the user.");
        }
    }
}