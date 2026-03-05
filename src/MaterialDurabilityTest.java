import java.util.Scanner; 

public class MaterialDurabilityTest {
    public static void main(String[] args) {
        double structuralIntegrity = 100.0; // Starting health of the material. 
        int cycleCount = 0; 
        final double FAILURE_THRESHOLD = 15.0; // The material is considered broken if it drops to this level.  

        Scanner myInput1 = new Scanner(System.in); 

        while (structuralIntegrity > FAILURE_THRESHOLD) {
            System.out.println(); 
            System.out.print("Enter pressure force for Cycle " + (cycleCount+1) + ": "); 
            double force = myInput1.nextDouble(); 

            structuralIntegrity -= force; 

            if (force > 20.0) {
                structuralIntegrity -= 5.0; 
            } 

            System.out.println("The structural integrity of the material is now " + structuralIntegrity + ". "); 

            cycleCount++; 
        } 

        System.out.println(); 
        System.out.println("Material Failure at Cycle " + cycleCount + "!"); 
        System.out.println("The final integrity level is " + structuralIntegrity + ". "); 
    }
}
