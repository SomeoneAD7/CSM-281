public class SkillRating {
    public static void main(String[] args){
        int[] ratings = {2, 3, 4, 3, 5, 3, 4, 5, 2, 2, 3, 3, 4, 5, 1, 2, 4, 1, 2, 5}; 

        int freq_1 = 0;
        int freq_2 = 0;
        int freq_3 = 0;
        int freq_4 = 0;
        int freq_5 = 0;

        for(int i = 0; i < ratings.length; i++){
            if(ratings[i] == 1){
                freq_1++;
            } 
            else if(ratings[i] == 2){
                freq_2++;
            } 
            else if(ratings[i] == 3){
                freq_3++;
            } 
            else if(ratings[i] == 4){
                freq_4++;
            } 
            else if(ratings[i] == 5){
                freq_5++;
            }
        }

        System.out.println("Rating Scale\tFrequency of Ocuurrence"); 
    }
}
