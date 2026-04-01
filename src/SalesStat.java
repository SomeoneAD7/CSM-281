import java.util.Scanner; 

public class SalesStat {
    public static void main(String[] args) {
        final int DIVISIONS = 6;
        final int QUARTERS  = 4;
        
        Scanner myInput = new Scanner(System.in);
        double[][] sales = new double[DIVISIONS][QUARTERS];

        System.out.println("===== Quarterly Sales Statistics =====");
        System.out.println("Enter sales figures for 6 divisions across 4 quarters.\n");

        for (int d = 0; d < DIVISIONS; d++) {
            for (int q = 0; q < QUARTERS; q++) {
                double val = -1;
                while (val < 0) {
                    System.out.printf("  Division %d, Quarter %d sales: $", d + 1, q + 1);
                    if (myInput.hasNextDouble()) {
                        val = myInput.nextDouble();
                        if (val < 0) System.out.println("Sales cannot be negative.");
                    } else {
                        System.out.println("Invalid input.");
                        myInput.next();
                    }
                }
                sales[d][q] = val;
            }
        }

        System.out.println("\n===== Sales Report by Quarter =====");

        double prevQuarterTotal = 0;

        for (int q = 0; q < QUARTERS; q++) {
            System.out.println("\n--- Quarter " + (q + 1) + " ---");

            double quarterTotal = 0;
            double highestSale  = sales[0][q];
            int    topDivision  = 1;

            for (int d = 0; d < DIVISIONS; d++) {
                double current  = sales[d][q];
                double prevSale;
                if (q > 0) {
                    prevSale = sales[d][q - 1];
                } else {
                    prevSale = 0;
                }
                double change   = current - prevSale;

                quarterTotal += current;
                if (current > highestSale) { highestSale = current; topDivision = d + 1; }

                System.out.printf("  Division %d: $%.2f", d + 1, current);
                if (q > 0) System.out.printf("  (change from prev quarter: %+.2f)", change);
                System.out.println();
            }

            double avgSales = quarterTotal / DIVISIONS;
            double qChange  = quarterTotal - prevQuarterTotal;

            System.out.printf("  Total Sales        : $%.2f%n", quarterTotal);
            if (q > 0) System.out.printf("  Company Change     : %+.2f%n", qChange);
            System.out.printf("  Average per Division: $%.2f%n", avgSales);
            System.out.printf("  Top Division       : Division %d ($%.2f)%n", topDivision, highestSale);

            prevQuarterTotal = quarterTotal;
        }
    }
}
