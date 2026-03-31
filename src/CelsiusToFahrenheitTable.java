public class CelsiusToFahrenheitTable{
    public static double celsiusToFahrenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }
    public static void main(String[] args){
        System.out.println("Celsius\tFahrenheit"); 
        for(double c = 0; c <= 20; c++){
            double f = celsiusToFahrenheit(c);
            System.out.printf("%.1f\t%.1f%n", c, f);
        }
    }
}