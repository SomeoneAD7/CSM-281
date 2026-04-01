import java.util.Scanner;

class RoulettePocket {
    private int pocketNumber;

    public RoulettePocket(int pocketNumber) {
        if (pocketNumber < 0 || pocketNumber > 36)
            throw new IllegalArgumentException("Pocket number must be between 0 and 36.");
        this.pocketNumber = pocketNumber;
    }

    public String getPocketColor() {
        if (pocketNumber == 0) return "Green";

        if (pocketNumber >= 1 && pocketNumber <= 10) {
            return (pocketNumber % 2 != 0) ? "Red" : "Black";
        } else if (pocketNumber >= 11 && pocketNumber <= 18) {
            return (pocketNumber % 2 != 0) ? "Black" : "Red";
        } else if (pocketNumber >= 19 && pocketNumber <= 28) {
            return (pocketNumber % 2 != 0) ? "Red" : "Black";
        } else {
            return (pocketNumber % 2 != 0) ? "Black" : "Red";
        }
    }
}

public class RouletteWheel {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("===== Roulette Wheel Pocket Colour =====");

        int pocket = -1;
        while (pocket < 0 || pocket > 36) {
            System.out.print("Enter a pocket number (0 - 36): ");
            if (myInput.hasNextInt()) {
                pocket = myInput.nextInt();
                if (pocket < 0 || pocket > 36)
                    System.out.println("Error: Pocket number must be between 0 and 36.");
            } else {
                System.out.println("Invalid input.");
                myInput.next();
            }
        }

        RoulettePocket rp = new RoulettePocket(pocket);
        System.out.println("Pocket " + pocket + " is: " + rp.getPocketColor());
    }
}
