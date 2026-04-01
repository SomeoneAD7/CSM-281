import java.util.Scanner; 

public class CinemaTicketBooking {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in); 
        
        final double REGULAR_PRICE = 25.00;
        final double STUDENT_PRICE = 15.00;
        final double VIP_PRICE = 50.00;


        int totalTickets = 0;
        double totalCost = 0;
        int option; 

        System.out.println("===== Cinema Ticket Booking Kiosk =====");

        do {
            System.out.println("\n--- Ticket Menu ---");
            System.out.println("1. Regular  - GHS 25.00");
            System.out.println("2. Student  - GHS 15.00");
            System.out.println("3. VIP      - GHS 50.00");
            System.out.println("4. Finish Booking");
            System.out.print("Select an option: ");

            if (!myInput.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1, 2, 3 or 4.");
                myInput.next();
                option = 0;
                continue;
            }

            option = myInput.nextInt();

            switch (option) {
                case 1:
                    totalTickets++;
                    totalCost += REGULAR_PRICE;
                    System.out.println("  Regular ticket added.");
                    break;
                case 2:
                    totalTickets++;
                    totalCost += STUDENT_PRICE;
                    System.out.println("  Student ticket added.");
                    break;
                case 3:
                    totalTickets++;
                    totalCost += VIP_PRICE;
                    System.out.println("  VIP ticket added.");
                    break;
                case 4:
                    System.out.println("  Finishing booking...");
                    break;
                default:
                    System.out.println("Invalid option. Choose between 1 and 4.");
            }
        } 
        while (option != 4);  

        System.out.println("\n===== Booking Summary =====");
        System.out.println("Total Tickets : " + totalTickets);
        System.out.printf("Total Cost    : GHS %.2f%n", totalCost);

        if (totalTickets == 0) {
            System.out.println("Booking Type  : No tickets booked.");
        } else if (totalTickets <= 3) {
            System.out.println("Booking Type  : Standard booking.");
        } else {
            System.out.println("Booking Type  : Group booking.");
        }
    }
}
