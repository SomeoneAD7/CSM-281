import java.util.Scanner;

public class NumberAnalysis {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner myInput1 = new Scanner(System.in);

        System.out.print("Enter start of range: ");
        int start = myInput1.nextInt();

        System.out.print("Enter end of range: ");
        int end = myInput1.nextInt();

        // ---- COUNT ODD NUMBERS FIRST ----
        int oddCount = 0;
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }

        // ---- STORE ODD NUMBERS ----
        int[] k = new int[oddCount];
        int index = 0;

        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                k[index] = i;
                index++;
            }
        }

        // ---- ODD AVERAGE ----
        double oddSum = 0.0;
        for (int i = 0; i < k.length; i++) {
            oddSum += k[i];
        }
        double oddAverage = oddSum / k.length;

        // ---- ODD FACTORIALS ----
        System.out.println("\nFactorials of Odd Numbers:");
        for (int i = 0; i < k.length; i++) {
            long factorial = 1;
            for (int j = 1; j <= k[i]; j++) {
                factorial *= j;
            }
            System.out.println(k[i] + "! = " + factorial);
        }

        // ---- ODD STANDARD DEVIATION ----
        double oddVarianceSum = 0.0;
        for (int i = 0; i < k.length; i++) {
            oddVarianceSum += Math.pow(k[i] - oddAverage, 2);
        }
        double oddVariance = oddVarianceSum / k.length;
        double oddStdDev = Math.sqrt(oddVariance);

        // ---- FACTORIAL OF ODD STANDARD DEVIATION ----
        int oddStdDevInt = (int) oddStdDev;
        long oddStdDevFact = 1;

        for (int i = 1; i <= oddStdDevInt; i++) {
            oddStdDevFact *= i;
        }

        // ---- ODD PRIMES ----
        int oddPrimeCount = 0;
        for (int i = 0; i < k.length; i++) {
            if (isPrime(k[i])) {
                oddPrimeCount++;
            }
        }

        // Store odd primes 
        int[] oddPrimeArray = new int[oddPrimeCount];
        int pIndex = 0;

        for (int i = 0; i < k.length; i++) {
            if (isPrime(k[i])) {
                oddPrimeArray[pIndex] = k[i];
                pIndex++;
            }
        }


        // ---- EVEN SECTION STARTS HERE ----

        // ---- COUNT EVEN NUMBERS ----
        int evenCount = 0;
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                evenCount++;
            }
        }

        // ---- STORE EVEN NUMBERS ----
        int[] evenNumbers = new int[evenCount];
        int evenIndex = 0;

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            }
        }

        // ---- EVEN AVERAGE ----
        double evenSum = 0.0;
        for (int i = 0; i < evenNumbers.length; i++) {
            evenSum += evenNumbers[i];
        }
        double evenAverage = evenSum / evenNumbers.length;

        // ---- EVEN FACTORIALS ----
        System.out.println("\nFactorials of Even Numbers:");
        for (int i = 0; i < evenNumbers.length; i++) {
            long evenFactorial = 1;
            for (int j = 1; j <= evenNumbers[i]; j++) {
                evenFactorial *= j;
            }
            System.out.println(evenNumbers[i] + "! = " + evenFactorial);
        }

        // ---- EVEN STANDARD DEVIATION ----
        double evenVarianceSum = 0.0;
        for (int i = 0; i < evenNumbers.length; i++) {
            evenVarianceSum += Math.pow(evenNumbers[i] - evenAverage, 2);
        }
        double evenVariance = evenVarianceSum / evenNumbers.length;
        double evenStdDev = Math.sqrt(evenVariance);

        // ---- FACTORIAL OF EVEN STANDARD DEVIATION ----
        int evenStdDevInt = (int) evenStdDev;
        long evenStdDevFact = 1;

        for (int i = 1; i <= evenStdDevInt; i++) {
            evenStdDevFact *= i;
        }

        // ---- EVEN PRIMES ----
        int evenPrimeCount = 0;
        for (int i = 0; i < evenNumbers.length; i++) {
            if (isPrime(evenNumbers[i])) {
                evenPrimeCount++;
            }
        }

        int[] evenPrimeArray = new int[evenPrimeCount];
        int evenPIndex = 0;

        for (int i = 0; i < evenNumbers.length; i++) {
            if (isPrime(evenNumbers[i])) {
                evenPrimeArray[evenPIndex] = evenNumbers[i];
                evenPIndex++;
            }
        }

        // ---- FINAL OUTPUT ----
        System.out.println("\nOdd Average: " + oddAverage);
        System.out.println("Odd Standard Deviation: " + oddStdDev);
        System.out.println("Factorial of Odd Standard Deviation (integer part): " + oddStdDevFact); 

        System.out.println("\nEven Average: " + evenAverage);
        System.out.println("Even Standard Deviation: " + evenStdDev);
        System.out.println("Factorial of Even Standard Deviation (integer part): " + evenStdDevFact);

        System.out.println("\nOdd Prime Numbers:");
        for (int i = 0; i < oddPrimeArray.length; i++) {
            System.out.println(oddPrimeArray[i]);
        }

        System.out.println("\nEven Prime Numbers:");
        for (int i = 0; i < evenPrimeArray.length; i++) {
            System.out.println(evenPrimeArray[i]);
        }
    } 

    // ---- PRIME CHECKER METHOD ----
    public static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
