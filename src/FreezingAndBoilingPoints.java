import java.util.Scanner;

class TemperatureChecker {
    private double temperature;

    // Freezing/boiling points 
    private static final double ethyl_freezing  = -173;
    private static final double ethyl_boiling   =  172;
    private static final double oxygen_freezing = -362;
    private static final double oxygen_boiling  = -306;
    private static final double water_freezing  =   32;
    private static final double water_boiling   =  212;

    public TemperatureChecker() {this.temperature = 0;}  // This is a default constructor that initializes temperature to 0. 
    public TemperatureChecker(double temperature) {this.temperature = temperature;}  // This is a constructor that initializes temperature to the provided value. 

    public void setTemperature(double t) {this.temperature = t;}  // This is the mutator method. 
    public double getTemperature(){return temperature;}  // This is the accessor method. 

    public boolean isEthylFreezing()  { return temperature <= ethyl_freezing; }
    public boolean isEthylBoiling()   { return temperature >= ethyl_boiling; }
    public boolean isOxygenFreezing() { return temperature <= oxygen_freezing; }
    public boolean isOxygenBoiling()  { return temperature >= oxygen_boiling; }
    public boolean isWaterFreezing()  { return temperature <= water_freezing; }
    public boolean isWaterBoiling()   { return temperature >= water_boiling; }
}

public class FreezingAndBoilingPoints {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("===== Freezing & Boiling Point Checker =====");
        System.out.print("Enter a temperature (°F) : ");

        while (!myInput.hasNextDouble()) {
            System.out.println("Invalid input.");
            myInput.next();
        }
        double temp = myInput.nextDouble();

        TemperatureChecker checker = new TemperatureChecker(temp);

        System.out.printf("%nAt %.2f°F :%n", temp);
        System.out.println("-- Freezing --");
        System.out.println("  Ethyl Alcohol freezes : " + (checker.isEthylFreezing()  ? "YES" : "No"));
        System.out.println("  Oxygen freezes        : " + (checker.isOxygenFreezing() ? "YES" : "No"));
        System.out.println("  Water freezes         : " + (checker.isWaterFreezing()  ? "YES" : "No"));
        System.out.println(); 
        System.out.println("-- Boiling --");
        System.out.println("  Ethyl Alcohol boils   : " + (checker.isEthylBoiling()  ? "YES" : "No"));
        System.out.println("  Oxygen boils          : " + (checker.isOxygenBoiling() ? "YES" : "No"));
        System.out.println("  Water boils           : " + (checker.isWaterBoiling()  ? "YES" : "No"));
    }
}
