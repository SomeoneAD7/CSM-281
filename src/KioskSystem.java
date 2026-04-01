import java.util.Scanner;

public class KioskSystem {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        final double BURGER_PRICE = 5.99;
        final double FRIES_PRICE  = 2.50;
    
        double grandTotal  = 0;
        int    totalItems  = 0;
        int    choice;

        System.out.println("===== Fast-Food Kiosk Terminal =====");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Burger  - $5.99");
            System.out.println("2. Fries   - $2.50");
            System.out.println("3. Checkout");
            System.out.print("Select an option: ");

            if (!myInput.hasNextInt()) {
                System.out.println("Invalid input. Enter 1, 2, or 3.");
                myInput.next();
                choice = 0;
                continue;
            }

            choice = myInput.nextInt();

            if (choice == 1) {
                int qty = getPositiveQuantity(myInput, "Enter quantity of Burgers: ");
                grandTotal += qty * BURGER_PRICE;
                totalItems += qty;
                if(qty == 1) {
                    System.out.println("  Added " + qty + " Burger to cart.");
                } else {
                    System.out.println("  Added " + qty + " Burgers to cart.");
                }
            } else if (choice == 2) {
                int qty = getPositiveQuantity(myInput, "Enter quantity of Fries: ");
                grandTotal += qty * FRIES_PRICE;
                totalItems += qty;
                System.out.println("  Added " + qty + " Fries to cart.");

            } else if (choice == 3) {
                System.out.println("  Proceeding to checkout...");

            } else {
                System.out.println("Invalid option. Choose 1, 2, or 3.");
            }

        } while (choice != 3);

        System.out.println("\n===== Checkout Summary =====");
        System.out.println("Total Items : " + totalItems);
        System.out.printf("Total Bill  : $%.2f%n", grandTotal);
    }

    private static int getPositiveQuantity(Scanner myInput, String prompt) {
        int qty;
        while (true) {
            System.out.print(prompt);
            if (myInput.hasNextInt()) {
                qty = myInput.nextInt();
                if (qty > 0) return qty;
                System.out.println("Quantity cannot be zero or negative. Please try again.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                myInput.next();
            }
        }
    }
}
