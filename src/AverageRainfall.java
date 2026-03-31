import java.util.Scanner; 

public class AverageRainfall{
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in); 

        System.out.print("Enter the number of years : "); 
        int years = myInput.nextInt();  

        if(years < 1){
            System.out.println("Invalid input! Number of years must be greater than 0.");
            return; 
        }

        int months = years * 12; 
        double totalRainfall = 0; 
        double avgRainfall = 0; 

        System.out.println();

        for(int i = 1; i <= years; i++){
            for(int j = 1; j <= 12; j++){
                System.out.print("Enter the inches of rainfall for month " + j + " of year " + i + " : ");
                double rainfall = myInput.nextDouble(); 

                if(rainfall < 0){
                    System.out.println("Invalid input! Rainfall cannot be negative.");
                    return; 
                }
                else{
                    totalRainfall += rainfall; 
                }
            } 

            System.out.println();
        } 

        avgRainfall = totalRainfall / months;

        System.out.println(); 
        System.out.println("The number of months elapsed is " + months + " months.");
        System.out.println("The total inches of rainfall is " + totalRainfall);
        System.out.printf("The average rainfall per month for the entire period of " + years + " years is %.4f", avgRainfall); 
    }
}