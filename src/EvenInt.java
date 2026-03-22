import java.util.Scanner; 

public class EvenInt{
    public static long fact(int n){ // function for calculating factorial 
        if(n == 0 || n ==1){
            return 1;
        } 
        else{
            return n * fact(n-1); 
        }
    } 

    public static double standardDeviation(double a, double b) { // Function to compute standard deviation of two values
        double mean = (a + b) / 2.0;
        double variance = ((a - mean) * (a - mean) + (b - mean) * (b - mean)) / 2.0;
        return Math.sqrt(variance);
    }

    public static void main(String[] args){
        int[] even_integers = new int[10]; 

        Scanner myInput = new Scanner(System.in); 

        for(int i = 0; i < 20; i++){ // Accepts first 20 integers 
            System.out.print("Enter the first 20 integers : ");
            int input = myInput.nextInt(); 

            if(input % 2 == 0){ // Filters even numbers out and stores them in an array 
                even_integers[i/2] = input; 
            } 
        } 

        System.out.println(); 

        /*for (int i = 0; i < n; i++){
            System.out.print(even_integers[i] + " ");
        } */ 

        double even_sum = 0;
        double even_avg = 0; 
        int n = even_integers.length;

        for (int i = 0; i < n; i++){
            even_sum += even_integers[i]; 
        } 

        even_avg = even_sum / n; 

        int int_even_avg = (int) even_avg; 
        long even_fact = fact(int_even_avg); 

        double sqrt_even_fact = Math.sqrt(even_fact); // Calculates for square root of the factorial obtained. 

        double even_sd = standardDeviation(sqrt_even_fact, even_fact); // Calculates for the standard deviation of the square root output and the factorial result.

        System.out.println("The average is " + even_avg);
        System.out.println("The factorial of the average is " + even_fact); 
        System.out.printf("The square root of the factorial is %.4f%n", sqrt_even_fact);  // The %.4f is used to format the output to 4 decimal places.
        System.out.printf("The standard deviation of the square root and the factorial is %.4f%n", even_sd);
    }
}