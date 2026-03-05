import java.util.Scanner; 

public class QualityControl {
    public static void main(String[] args) {
        double boardHealth = 100.0; 
        int spikeCount = 0; 
        int userChoice = 1;  // 1 to continue, 0 to stop 

        Scanner myInput1 = new Scanner(System.in);  

        do {
            spikeCount++; 
            System.out.print("Enter amount of damage for Power Spike " + spikeCount + ": ");
            double damage = myInput1.nextDouble(); 

            boardHealth -= damage; 

            System.out.println("The remaining health is " + boardHealth); 
            System.out.println(); 

            if (boardHealth <= 0) {
                System.out.println("FRIED \nTEST TERMINATED: Component Destroyed."); 
            } 
            else {
                System.out.print("Enter 1 to continue or 0 to stop : ");
                userChoice = myInput1.nextInt(); 
            } 
        } 

        while (boardHealth > 0 && userChoice == 1); 

        System.out.println(); 
        // System.out.println("The current health of the circuit board is " + boardHealth + ". "); 
        System.out.println("The circuit board survived " + spikeCount + " power spikes."); 
    }
}
