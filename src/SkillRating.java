public class SkillRating {
    public static void main(String[] args) {

        // The 20 ratings given by students
        int[] ratings = {2, 3, 4, 3, 5, 3, 4, 5, 2, 2, 3, 3, 4, 5, 1, 2, 4, 1, 2, 5};

        // Array to store frequency of each rating (index 1 to 5)
        // We use size 6 so that the index matches the rating directly
        // i.e. frequency[1] = count of rating 1,
        //      frequency[2] = count of rating 2, etc.
        int[] frequency = new int[6];

        // Count the frequency of each rating
        for (int i = 0; i < ratings.length; i++) {
            frequency[ratings[i]] = frequency[ratings[i]] + 1;
        }

        // We will sort the rating scales (1-5) by their frequency
        // using a simple bubble sort in descending order of frequency

        // First, create an array to hold the rating scale values 1 to 5
        int[] ratingScale = {1, 2, 3, 4, 5};

        // Bubble sort: sort ratingScale array based on their frequency values
        // descending order means highest frequency comes first
        for (int i = 0; i < ratingScale.length - 1; i++) {
            for (int j = 0; j < ratingScale.length - 1 - i; j++) {
                // If the frequency of ratingScale[j] is LESS than ratingScale[j+1]
                // swap them so the higher frequency comes first
                if (frequency[ratingScale[j]] < frequency[ratingScale[j + 1]]) {
                    int temp = ratingScale[j];
                    ratingScale[j] = ratingScale[j + 1];
                    ratingScale[j + 1] = temp;
                }
            }
        }

        // Display the results in descending order of frequency (magnitude)
        System.out.println("===== Student Java Skill Ratings =====");
        System.out.println();
        System.out.printf("%-15s %-20s%n", "RATING SCALE", "FREQUENCY OF OCCURRENCE");
        System.out.println("---------------------------------------");

        for (int i = 0; i < ratingScale.length; i++) {
            System.out.printf("%-15d %-20d%n", ratingScale[i], frequency[ratingScale[i]]);
        }

        System.out.println("---------------------------------------");
        System.out.println("Total students surveyed: " + ratings.length);
    }
}
