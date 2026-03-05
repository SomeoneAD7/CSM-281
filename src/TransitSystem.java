import java.util.Scanner;

public class TransitSystem {

    public static void main(String[] args) {

        double cardBalance = 15.00;
        final double RIDE_COST = 2.50;
        int failedAttempts = 0;

        Scanner myInput1 = new Scanner(System.in);

        while (cardBalance >= RIDE_COST && failedAttempts < 3) {

            System.out.print("Do you want to take a ride? (Enter 1 for Yes, 0 for No): ");
            int userChoice = myInput1.nextInt();

            if (userChoice == 1) {
                cardBalance -= RIDE_COST;
                System.out.println("Ride successful! Remaining balance: " + cardBalance);
            } else {
                failedAttempts++;
                System.out.println("No ride taken. Warning: " + failedAttempts + "/3 inactivity marks.");
            }

            System.out.println();
        }

        System.out.println("Final Balance: " + cardBalance);

        if (cardBalance < RIDE_COST) {
            System.out.println("Insufficient funds for another ride.");
        } 
        else if (failedAttempts >= 3) {
            System.out.println("Session timed out due to inactivity.");
        }
    }
}
