public class StanDev2 { 
    static long factorial(int n) {
        if (n == 0) {
            return 1; 
        } 
        else {
            return n * factorial(n-1); 
        }
    }
    public static void main(String[] args){
        int n = 10; 
        double sum = 0; 

        // calc 1st 10 integers. 
        for (int i = 1; i <= n; i++) {
            sum += i; 
        }  

        // System.out.println("THe sum is : " + sum); 

        // get average. 
        double avg = sum / n; 

        // System.out.println("The avg is : " + avg); 

        // calc standard deviation . 
            // calcualte variance sum 
        double varianceSum = 0; 

        for (int i= 1; i <= n; i++) {
            varianceSum += Math.pow(i - avg , 2); 
        } 

        // System.out.println("The varsum is : " + varianceSum); 

            // calc variance 
        double variance = varianceSum / n; 

        // calc stan dev. 
        double standardDeviation = Math.sqrt(variance); 
        int roundedSD = (int) Math.round(standardDeviation);  

        // calc factorial of stan dev. 
        long sdFact = factorial(roundedSD); 

        System.out.println("The average of the first 10 integers is : " + avg ); 
        System.out.println("The standard deviation is : " + standardDeviation);  
        System.out.println("The factorial of the standard deviation is : " + sdFact);  

    }
}
