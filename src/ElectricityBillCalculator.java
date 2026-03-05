import java.util.Scanner; 

public class ElectricityBillCalculator {
    public static void main(String[] args) {
        final double COST_PER_KWH = 0.20; 
        double totalConsumption = 0;
        double totalCost = 0; 

        Scanner myInput1 = new Scanner(System.in);
        System.out.print("What is the total number of appliances in your house? "); 

        int n = myInput1.nextInt(); 
        // System.out.println(); 

        for (int i = 1; i <= n; i++) {
            System.out.println(); 
            System.out.print("What is the power consumption for appliance " + i + " in kWh : "); 
            int consumption = myInput1.nextInt(); 

            double baseCost = COST_PER_KWH * consumption; 
            double calc_cost; 

            if (consumption > 100) {
                calc_cost = baseCost * 1.15; 
                System.out.println(); 
                System.out.println("The kWh consumption of appliance " + i + " exceeds 100kWh, therefore a 15% surcharge has been applied. "); 
            } 
            else {
                calc_cost = baseCost; 
            }

            System.out.println("Appliance " + i + " used " + consumption + "kWh of power. You have been charged GHc" + String.format("%.2f" , calc_cost) + ". "); 
            System.out.println(); 

            totalConsumption += consumption; 
            totalCost += calc_cost; 
        }  

        String roundedTotalCost = String.format("%.2f" , totalCost); 
        String roundedTotalConsumption = String.format("%.2f" , totalConsumption); 

        System.out.println("In total, your household consumed " + roundedTotalConsumption + "kWh of power and paid GHc" + roundedTotalCost + ". "); 

    }
}
