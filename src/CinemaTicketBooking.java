import java.util.Scanner; 

public class CinemaTicketBooking {
    public static void main(String[] args) {
        Scanner myInput1 = new Scanner(System.in); 
        System.out.print("Option : "); 
        int option = myInput1.nextInt(); 
        boolean run = true; 

        do {
            if (option == 1) {

            } 

            else if (option == 2) {

            } 

            else if (option == 3) {

            } 

            else if (option == 4) {
                run = false; 
            } 

            else {
                System.out.println("Incorrect option."); 
            }
        } 

        while (run);  
    }
}
