import java.util.Scanner;

public class MultipleStockSalesProfit {
    // Profit = ((NS * SP) - SC) - ((NS * PP) + PC)
    public static double calculateProfit(int numShares, double purchasePrice, double purchaseCommission, double salePrice, double saleCommission) {
        double revenue = (numShares * salePrice) - saleCommission;
        double cost    = (numShares * purchasePrice) + purchaseCommission;
        return revenue - cost;
    }

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("===== Multiple Stock Sales Calculator =====");

        int numSales = 0;
        while (numSales <= 0) {
            System.out.print("How many stock sales do you want to enter? ");
            if (myInput.hasNextInt()) {
                numSales = myInput.nextInt();
                if (numSales <= 0) System.out.println("Must be at least 1.");
            } else {
                System.out.println("Invalid input.");
                myInput.next();
            }
        }

        double totalProfit = 0;

        for (int i = 1; i <= numSales; i++) {
            System.out.println("\n-- Sale " + i + " --");
            int    ns  = getPositiveInt(myInput,    "  Number of shares: ");
            double pp  = getPositiveDouble(myInput, "  Purchase price per share ($): ");
            double pc  = getPositiveDouble(myInput, "  Purchase commission ($): ");
            double sp  = getPositiveDouble(myInput, "  Sale price per share ($): ");
            double scm = getPositiveDouble(myInput, "  Sale commission ($): ");

            double profit = calculateProfit(ns, pp, pc, sp, scm);
            totalProfit += profit;

            if (profit >= 0)
                System.out.printf("  Sale %d profit : $%.2f%n", i, profit);
            else
                System.out.printf("  Sale %d loss   : $%.2f%n", i, Math.abs(profit));
        }

        System.out.println("\n===== Overall Result =====");
        if (totalProfit > 0) {
            System.out.printf("Total Profit : $%.2f%n", totalProfit);
        } else if (totalProfit < 0) {
            System.out.printf("Total Loss   : $%.2f%n", Math.abs(totalProfit));
        } else {
            System.out.println("Break even across all sales.");
        }
    }

    static int getPositiveInt(Scanner myInput, String prompt) {
        int val = 0;
        while (val <= 0) {
            System.out.print(prompt);
            if (myInput.hasNextInt()) { val = myInput.nextInt(); if (val <= 0) System.out.println("Must be > 0."); }
            else { System.out.println("Invalid."); myInput.next(); }
        }
        return val;
    }

    static double getPositiveDouble(Scanner myInput, String prompt) {
        double val = -1;
        while (val < 0) {
            System.out.print(prompt);
            if (myInput.hasNextDouble()) { val = myInput.nextDouble(); if (val < 0) System.out.println("    !! Cannot be negative."); }
            else { System.out.println("Invalid."); myInput.next(); }
        }
        return val;
    }
}
