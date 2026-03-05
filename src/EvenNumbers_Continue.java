public class EvenNumbers_Continue {
    public static void main(String[] args) {
        // int evenCount = 0; 
        // int oddCount = 0; 

        int[] evenNums = new int[9]; 
        int[] oddNums = new int[38]; 

        int e = 0; 
        int o = 0; 
        
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                if (i == 0) continue; 
                if (i == 20) break; 
                else {
                    // System.out.println(i);
                    evenNums[e] = i; 
                    e++;                     
                }
            } 
            // evenCount++;               
        } 
        
        System.out.println(); 

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                if (i == 1 || i == 3) continue;
                if (i == 81) break; 
                else {
                    // System.out.println(i);
                    oddNums[o] = i; 
                    o++; 
                }
            } 
            // oddCount++; 
        } 

        for (int i = 0; i < evenNums.length; i++) {
            System.out.println(evenNums[i]); 
        } 
        System.out.println(); 
        for (int i = 0; i < oddNums.length; i++) {
            System.out.println(oddNums[i]); 
        }
        
    }
}
