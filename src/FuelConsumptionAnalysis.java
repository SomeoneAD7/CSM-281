public class FuelConsumptionAnalysis {
    public static void main(String[] args) {
        double[] fuelConsumption = {12.5, 22.0, 8.4, 18.6, 25.3, 9.8, 15.0}; 
        double totalFuelConsumption = 0.0; 
        double[] highFuel = new double[fuelConsumption.length]; 
        double[] normalFuel = new double[fuelConsumption.length]; 
        double[] lowFuel = new double[fuelConsumption.length]; 

        int highCount = 0;
        int normalCount = 0;  
        int lowCount = 0; 

        double max = fuelConsumption[0]; 

        int peakFuelDay = 1; 

        int i = 0; 

        while (i < fuelConsumption.length) {
            if (fuelConsumption[i] > 20) {
                highFuel[highCount] = fuelConsumption[i]; 
                highCount++; 
            } 
            else if (fuelConsumption[i] >= 10 && fuelConsumption[i] <= 20) {
                normalFuel[normalCount] = fuelConsumption[i]; 
                normalCount++; 
            } 
            else {
                lowFuel[lowCount] = fuelConsumption[i]; 
                lowCount++; 
            } 

           double currentFuel = fuelConsumption[i];
           totalFuelConsumption += fuelConsumption[i]; 

            if (currentFuel > max) {
                max = currentFuel; 
                peakFuelDay = i + 1; 
            }

            System.out.printf("Day %d: Fuel Consumption = %.2f liters %n" , i + 1 , currentFuel);

            i++; 
        }  

        double avgFuelConsumption = totalFuelConsumption / fuelConsumption.length; 

        System.out.println("\n--- Weekly Summary ---");
        System.out.printf("Total Fuel Consumption: %.2f liters%n", totalFuelConsumption);
        System.out.printf("Average Daily Consumption: %.2f liters%n", avgFuelConsumption);

        System.out.println("High Consumption Days: " + highCount);
        System.out.println("Normal Consumption Days: " + normalCount);
        System.out.println("Low Consumption Days: " + lowCount);

        System.out.printf("Peak Consumption Day: Day %d (%.2f liters)%n" , peakFuelDay , max); 
        
    }
}
