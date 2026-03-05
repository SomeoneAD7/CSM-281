
public class RefrigeratedWarehouse {

    public static void main(String[] args) {

        double[] temperatures = {2.5, 3.0, 15.0, 4.2, -1.0, 22.0, 3.8, 5.0};
        double sum = 0.0;
        int validSensorCount = 0;

        for (int i = 0; i < temperatures.length; i++) {

            double temp = temperatures[i];

            // 3. Filtering Logic
            if (temp <= 10.0) {
                sum += temp;
                validSensorCount++;
            } 
            else {
                System.out.println("Sensor " + (i + 1) + ": " + temp + "°C - ERROR: Reading Ignored");
            }
        }

        if (validSensorCount > 0) {
            double average = sum / validSensorCount;

            System.out.println();
            System.out.println("Total Valid Sensors Found: " + validSensorCount);
            System.out.println("Final Average Temperature: " + average + "°C"); 

        } else {
            System.out.println("No valid sensor readings found.");
        }
    }
}
