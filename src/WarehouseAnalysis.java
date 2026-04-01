public class WarehouseAnalysis {
    public static void main(String[] args) {
        double[] weights = {12.5, 55.0, 45.0, 18.0, 22.5, 60.0, 30.0, 15.0, 50.0, 10.0};

        int heavyCount  = 0;
        int mediumCount = 0;
        int lightCount  = 0;

        double totalWeight   = 0;
        double heaviestWeight = weights[0];
        int heaviestPos = 1;

        System.out.println("===== Warehouse Box Classification =====");
        System.out.println();

        for (int i = 0; i < weights.length; i++) {
            String category;
            if (weights[i] > 50) {
                category = "Heavy";
                heavyCount++;
            } else if (weights[i] >= 20 && weights[i] <= 50) {
                category = "Medium";
                mediumCount++;
            } else {
                category = "Light";
                lightCount++;
            }

            totalWeight += weights[i];

            if (weights[i] > heaviestWeight) {
                heaviestWeight = weights[i];
                heaviestPos = i + 1;
            }

            System.out.printf("Box %2d | %.1f kg | %s%n", i + 1, weights[i], category);
        }

        double averageWeight = totalWeight / weights.length;

        System.out.println();
        System.out.println("===== Summary =====");
        System.out.printf("Total Weight   : %.2f kg%n", totalWeight);
        System.out.printf("Average Weight : %.2f kg%n", averageWeight);
        System.out.println("Heavy boxes    : " + heavyCount);
        System.out.println("Medium boxes   : " + mediumCount);
        System.out.println("Light boxes    : " + lightCount);
        System.out.printf("Heaviest Box   : Box %d at %.1f kg%n", heaviestPos, heaviestWeight);
    }
}
