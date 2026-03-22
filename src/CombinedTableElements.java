public class CombinedTableElements{
    public static void main(String[] args) {
        int[][] combined = new int [2][6]; 
        int z = 0; 
        int[] addition = new int [6]; 

        int [][]x = {{1, 2, 3}, 
                     {4, 5, 6}}; 

        int [][]y = {{7, 8, 9}, 
                     {10, 11, 12}}; 

        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++){
                combined[0][z] += x[i][j];
                combined[1][z] += y[i][j];
                z++;
            }
        } 

        for(int i = 0; i < combined.length; i++){
            for(int j = 0; j < combined[i].length; j++){
                System.out.print(combined[i][j] + " ");
            }
            System.out.println();
        }  

        System.out.println(); 
    
        for(int l = 0; l < combined[row].length; l++){
            addition[l] = combined[0][l] + combined[1][l];
        }

        System.out.println("Addition of each column:");
        for(int m = 0; m < addition.length; m++){
            System.out.print(addition[m] + " ");
        } 

        System.out.println(); 


    }
}