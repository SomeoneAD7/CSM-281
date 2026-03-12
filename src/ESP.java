import java.util.*; 

public class ESP{
    public static void main(String[] args){
        String[] colours = {"Red", "Green", "Blue", "Orange",  "Yellow"}; 
        Scanner myinput = new Scanner(System.in);
        Random rand = new Random();

        int randNum = rand.nextInt(5); // (0-4) 

        System.out.print("Welcome to the ESP Game!");
        
        for(int i = 1; i <= 10; i++){
            System.out.print("Guess the colour : "); 
            
        }
    }
}