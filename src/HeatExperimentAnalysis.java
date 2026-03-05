import java.util.Scanner; 

public class HeatExperimentAnalysis {
    public static void main(String[] args) {
        Scanner myInput1 = new Scanner(System.in); 
        System.out.print("How many experiments will you be conducting? "); 
        int n = myInput1.nextInt(); 

        double totalAvgTemp = 0; 

        for (int i = 1; i <= n; i++){
            System.out.println(); 
            System.out.println("Experiment " + i); 
            System.out.print("Enter the temperature in the morning : "); 
            double morningTemp = myInput1.nextDouble(); 

            System.out.print("Enter the temperature in the evening : "); 
            double eveningTemp = myInput1.nextDouble(); 

            double avgTemp = (morningTemp + eveningTemp) / 2; 

            if (avgTemp > 100) {
                System.out.println(); 
                System.out.println("Experiment " + i + " : " + avgTemp + "°C - STATUS: UNSTABLE"); 
            }
            else { 
                System.out.println(); 
                System.out.println("Experiment " + i + " : " + avgTemp + "°C - STATUS: NORMAL");
            }

            totalAvgTemp += avgTemp; 

        }  

        double finalAvgTemp = totalAvgTemp / n; 

        System.out.println(); 
        System.out.println("The final average for the whole lab session is : " + finalAvgTemp + "."); 
    }
}
