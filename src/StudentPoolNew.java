import java.util.Scanner;
import java.util.InputMismatchException; 
import java.util.*; 

public class StudentPoolNew {
    public static void main(String[] args){
        Scanner myInput = new Scanner(System.in); 
        int k = 0; 
        int[] responses = {1, 1, 1, 4, 3, 4, 2, 1, 1, 4, 3, 5, 3, 2, 2, 4, 3, 4, 4, 7}; 
        int[] frequency = new int[4]; 

        for(int answer = 0; answer < responses.length; answer++) {
            try{
            ++frequency[responses[answer]]; 
            } 
            catch(InputMismatchException e){
                System.out.println("Wrong input supplied.");
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                System.out.printf(" responses[%d] = %d\n\n", answer, responses[answer]); 
            }
            catch(Exception e){
                System.out.println(e);
            } 
            finally{

            }
        } 

        System.out.printf("%s%6s\n", "Rating", "Frequency"); 

        for(int rating = 1; rating < frequency.length; rating++) {
            System.out.printf("%d%15d\n", rating, frequency[rating]);
        }
    }
}
