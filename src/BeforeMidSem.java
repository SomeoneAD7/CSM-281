// import java.util.Scanner; 

public class BeforeMidSem {
    public static void main(String[] args) {
        double[] shoeSize = new double[10];  
        double[] ghanaDebt = new double[10]; 
        char[] englAlphabets = new char[26]; 

        // 2D arrays 
        // in 2D arrays, the size of arrays is the no of rows. 

        int[][] n = {{7, 4, 8, 3}, {2, 5, 6, 1}, {9, 8, 4, 2}};  // this is a 3*4 matrix 
        int [][] k = {{7, 4, 8}, {2, 4, 6}, {9, 8, 4}, {4, 2, 1}};  // this is a 4*3 matrix 
        int k2[][] = {{3,4,5,6}, {2,4,8}}; 

        for (int[] numA:n){
            for (int num:numA) {
                System.out.print(num);
            }
            System.out.println(); 
        } 

        System.out.println(); 

        // declaring 2D array 

        String[][] k3 = new String[4][3]; 

        int[] n2 = {4, 9, 8, 7}; 
        int sum2 = 0; 
        for (int num2:n2) {
            sum2 += num2; 
        }

        System.out.println("THe sum is : " + sum2); 

        System.out.println(); 


        // rating scale exercise 
        int[] rating = {2,3,4,3,5,3,4,5,2,2,3,3,4,5,1,2,4,1,2,2}; 

        int one = 0; 
        int two = 0; 
        int three = 0; 
        int four = 0; 
        int five = 0;

        for (int rate:rating) {
            if (rate == 1) {
                one++; 
            } 
            else if (rate == 2) {
                two++; 
            } 
            else if (rate == 3) {
                three++; 
            } 
            else if (rate == 4){
                four++; 
            } 
            else if (rate == 5){
                five++; 
            }
        } 

        /*System.out.println("1 appears " + one + " times. "); 
        System.out.println("2 appears " + two + " times. "); 
        System.out.println("3 appears " + three + " times. "); 
        System.out.println("4 appears " + four + " times. "); 
        System.out.println("5 appears " + five + " times. "); 

        System.out.println(); */ 
        
        for (int i = rating.length; i > 0; i--) {
            if (i == one){
                System.out.println("1 appears " + one + " times. "); 
            } 

            else if (i == two){
                System.out.println("2 appears " + two + " times. ");
            } 

            else if (i == three){
                System.out.println("3 appears " + three + " times. ");
            } 

            else if (i == four){
                System.out.println("4 appears " + four + " times. ");
            } 

            else if (i == five){
                System.out.println("5 appears " + five + " times. ");
            }
        } 

        System.out.println(); 

        // Missing break 

        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                case 1:
                case 2: 
                case 3:
                case 4: 
                    System.out.println(i + " is less than 5");
                    break; 
                case 5: 
                    System.out.println(); 
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.println(i + " is less than 1o");
                    
                    break; 
                default:
                    System.out.println(i + " is 10 or more");
                    
            }
        }

    }
}
