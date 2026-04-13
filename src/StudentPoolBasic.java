// MAKE SURE YOU ASK AI TO EXPLAIN THE CODE TO YOU!!! 

public class StudentPoolBasic {
    public static void main(String[] args){
        int[] responses = {1, 1, 1, 4, 3, 4, 2, 1, 1, 4, 3, 5, 3, 2, 2, 4, 3, 4, 4, 7}; 
        int[] frequency = new int[8]; 

        for(int i = 0; i < responses.length; i++) {
            ++frequency[responses[i]]; 
        } 

        System.out.printf("%s%6s\n", "Rating", "Frequency"); 

        for(int rating = 1; rating < frequency.length; rating++) {
            System.out.printf("%d%15d\n", rating, frequency[rating]);
        }
    }
}
