// use while loop to process 
// 1. store scores of 6 students 

public class GradeReport {
    public static void main(String[] args) {
        int[] scores = {24, 98, 67, 65, 35, 89};  
        int totalScore = 0; 

        int i = 0; 

        while (i < scores.length) {
            int currentScore = scores[i]; 
            System.out.println("\nStudent " + (i + 1) +  " scored " + currentScore); 

            if (currentScore > 90) {
                System.out.println("Well done student " + (i+1) + ". \n");
            } 
            i++; 
        }
    }
}

