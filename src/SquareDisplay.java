import java.util.Scanner;

public class SquareDisplay {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in); 

        System.out.print("Enter a positive integer no greater than 15 : "); 
        int num = myInput.nextInt(); 

        System.out.println(); 

        if(num <= 15){
            for(int i = 1; i <= num; i++){
                for(int j = 1; j <= num; j++){
                    System.out.print("x");
                }
                System.out.println(); 
            }
        } 
        else{
            System.out.println("Your number is greater than 15!"); 
        }
    }
}
