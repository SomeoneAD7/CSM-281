import java.util.*; 

public class OddNum80 {
    // Check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Compute factorial — returns -1 if value is too large (> 20)
    static long factorial(int n) {
        if (n < 0) return -1;
        if (n > 20) return -1;  // overflow guard
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    // Standard deviation of an integer array
    static double stdDev(int[] arr) {
        double mean = 0;
        for (int v : arr) mean += v;
        mean /= arr.length;
        double varianceSum = 0;
        for (int v : arr) varianceSum += Math.pow(v - mean, 2);
        double variance = varianceSum / arr.length; 
        double stddev = Math.sqrt(variance);
        return stddev;
    }

    static void analyse(int start, int end, boolean doOdd) {
        String label;
        if (doOdd) {
            label = "ODD";
        } else {
            label = "EVEN";
        }

        System.out.println("\n========== " + label + " NUMBERS from " + start + " to " + end + " ==========");

        ArrayList<Integer> list = new ArrayList<>();

        // The required loop structure, using a counter
        for (int i = start; i <= end; i++) {
            boolean condition = doOdd ? (i % 2 != 0) : (i % 2 == 0);
            if (condition) list.add(i);
        }

        if (list.isEmpty()) {
            System.out.println("No " + label.toLowerCase() + " numbers in this range.");
            return;
        }

        // Store in array K
        int[] K = new int[list.size()];
        for (int i = 0; i < list.size(); i++) K[i] = list.get(i);

        System.out.print(label + " numbers : ");
        for (int v : K) System.out.print(v + " ");
        System.out.println();

        // Average
        double sum = 0;
        for (int v : K) sum += v;
        double avg = sum / K.length;
        System.out.printf("Average: %.4f%n", avg);

        // Factorial of each element
        System.out.println("Factorials:");
        for (int v : K) {
            long f = factorial(v);
            if (f == -1) {
                System.out.printf("  %d! = (too large to compute)%n", v);
            } else {
                System.out.printf("  %d! = %d%n", v, f);
            }
        }

        // Standard deviation
        double sd = stdDev(K);
        System.out.printf("Standard Deviation: %.4f%n", sd);

        // Prime numbers from K
        ArrayList<Integer> primes = new ArrayList<>();
        for (int v : K) {
            if (isPrime(v)) primes.add(v);
        }

        System.out.print("Prime numbers : ");
        if (primes.isEmpty()) {
            System.out.println("None");
        } else {
            int[] primeArr = new int[primes.size()];
            for (int i = 0; i < primes.size(); i++) primeArr[i] = primes.get(i);
            for (int p : primeArr) System.out.print(p + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("===== Odd & Even Number Analyser =====");
        System.out.println("This program works for any range you specify.\n");

        int start = getInt(myInput, "Enter the start of the range : ");
        int end   = getInt(myInput, "Enter the end of the range : ");

        if (start > end) {
            int tmp = start; start = end; end = tmp;
            System.out.println("(Range reversed to " + start + " - " + end + ")");
        }

        analyse(start, end, true);   // Odd
        analyse(start, end, false);  // Even
    }

    static int getInt(Scanner myInput, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (myInput.hasNextInt()) return myInput.nextInt();
            System.out.println("Enter a valid integer.");
            myInput.next();
        }
    }
}
