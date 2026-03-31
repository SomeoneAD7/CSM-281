import java.util.Scanner; 

public class Population {
    public static void main(String[] args){
        Scanner myInput = new Scanner(System.in);
        double finalPop = 0;  

        System.out.print("Enter the starting number of organisms : ");
        int startPop = myInput.nextInt(); 

        if(startPop < 2){
            System.out.println("Invalid input! Starting number of organisms must be at least 2.");
            return; 
        } 

        System.out.print("Enter the daily increase rate (as a percentage) : ");
        double avgIncreaseRate = myInput.nextDouble(); 

        if(avgIncreaseRate < 0){
            System.out.println("Invalid input! The average daily population increase has to be positive.");
            return;
        }

        System.out.print("Enter the number of days the organisms will take to multiply : ");
        int days = myInput.nextInt(); 

        if(days < 1){
            System.out.println("Invalid input! The number of days they will multiply must be at least 1.");
            return; 
        } 

        System.out.println(); 

        finalPop = startPop; 

        for(int i = 1; i <= days; i++){
            double popIncrease = finalPop * (avgIncreaseRate / 100);
            finalPop += popIncrease; 

            System.out.println("The population on day " + i + " is " + (int)finalPop);
        }
    }
}
