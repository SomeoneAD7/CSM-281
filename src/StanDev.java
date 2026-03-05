public class StanDev {
    static int facto(int n) { 
        if (n == 0) {
            return 1; 
        } 
        else { 
            return n * facto(n - 1); 
        }
    }
    public static void main(String[] args) {
        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 

        double sum = 0; 

        for (int inte : integers) {
            sum += inte; 
        }  

        System.out.println("The sum is : " + sum);

        double avg =sum/integers.length;
        System.out.println("the avg is : " + avg);

        /*Calculating the standard deviation */

        double varianceSum =0;
        for (int x : integers) {
            varianceSum += Math.pow(x - avg,2);
        }
        double variance = varianceSum / integers.length;
        @SuppressWarnings("unused")
        double standardDeviation = Math.sqrt(variance);


         int roundedSD = (int) Math.round(standardDeviation);
        long sdFactorial = facto(roundedSD);
        

        System.out.println("Average (Mean): " + avg);
        System.out.println("Standard Deviation: " + standardDeviation);
        System.out.println("Rounded Standard Deviation: " + roundedSD);
        System.out.println("Factorial of Standard Deviation: " + sdFactorial);





    

    }
}
