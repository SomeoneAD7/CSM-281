import java.util.Scanner;

public class SimplifiedATM {

    public static void main(String[] args) {

        double balance = 1000.0;
        int transactionCount = 0;
        int userAction;

        Scanner myInput = new Scanner(System.in);

        do {

            System.out.println();
            System.out.println("=== ATM MENU ===");
            System.out.println("1. Withdraw $100");
            System.out.println("2. Deposit $100");
            System.out.println("0. Exit & Print Receipt");
            System.out.print("Select an option: ");

            userAction = myInput.nextInt();

            if (userAction == 1) {
                if (balance >= 100) {
                    balance -= 100;
                    transactionCount++;
                    System.out.println("Withdrawal successful. New balance: " + balance);
                } else {
                    System.out.println("Insufficient Funds!");
                }
            } 
            else if (userAction == 2) {
                balance += 100;
                transactionCount++;
                System.out.println("Deposit successful. New balance: " + balance);
            } 
            else if (userAction != 0) {
                System.out.println("Invalid option. Please try again.");
            }
        } while (userAction != 0);

        System.out.println();
        System.out.println("=== SESSION SUMMARY ===");
        System.out.println("Final Balance: " + balance);
        System.out.println("Total Transactions: " + transactionCount);

    }
}
