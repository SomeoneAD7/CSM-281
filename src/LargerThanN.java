import java.util.Scanner;

public class LargerThanN {

    public static void displayLargerThan(int[] array, int n) {
        System.out.println("\nNumbers in the array greater than " + n + ":");
        boolean found = false;
        for (int val : array) {
            if (val > n) {
                System.out.println("  " + val);
                found = true;
            }
        }
        if (!found) System.out.println("  (none)");
    }

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("===== Larger Than N =====");

        int size = 0;
        while (size <= 0) {
            System.out.print("How many integers in the array? ");
            if (myInput.hasNextInt()) {
                size = myInput.nextInt();
                if (size <= 0) System.out.println("Must be at least 1.");
            } else {
                System.out.println("Invalid input.");
                myInput.next();
            }
        }

        int[] array = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            System.out.printf("  [%d]: ", i + 1);
            while (!myInput.hasNextInt()) { System.out.println("Invalid."); myInput.next(); }
            array[i] = myInput.nextInt();
        }

        System.out.print("\nEnter the value of n: ");
        while (!myInput.hasNextInt()) { System.out.println("Invalid."); myInput.next(); }
        int n = myInput.nextInt();

        displayLargerThan(array, n);
    }
}
