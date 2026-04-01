import java.util.Scanner;

class GradeBookClass {
    private String[] names    = new String[5];
    private double[][] scores = new double[5][4];

    public void setName(int student, String name)          { names[student] = name; }
    public void setScore(int student, int test, double s)  { scores[student][test] = s; }
    public String getName(int student)                     { return names[student]; }

    public double getAverageDropLowest(int student) {
        double min = scores[student][0];
        double sum = 0;
        for (double s : scores[student]) {
            sum += s;
            if (s < min) min = s;
        }
        return (sum - min) / (scores[student].length - 1);
    }

    public char getLetterGrade(int student) {
        double avg = getAverageDropLowest(student);
        if (avg >= 90 && avg <= 100) return 'A';
        if (avg >= 80 && avg <= 89) return 'B';
        if (avg >= 70 && avg <= 79) return 'C';
        if (avg >= 60 && avg <= 69) return 'D';
        return 'F';
    }
}

public class GradeBook {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        GradeBookClass gb = new GradeBookClass();

        System.out.println("===== Grade Book (Drops Lowest Score) =====");

        for (int s = 0; s < 5; s++) {
            System.out.println("\nStudent " + (s + 1) + ":");
            System.out.print("  Name: ");
            String name = myInput.nextLine().trim();
            while (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                System.out.print("  Name: ");
                name = myInput.nextLine().trim();
            }
            gb.setName(s, name);

            for (int t = 0; t < 4; t++) {
                double score = -1;
                while (score < 0 || score > 100) {
                    System.out.printf("  Test %d score (0-100): ", t + 1);
                    if (myInput.hasNextDouble()) {
                        score = myInput.nextDouble();
                        if (score < 0 || score > 100) System.out.println("Must be 0-100.");
                    } else {
                        System.out.println("Invalid input.");
                        myInput.next();
                    }
                }
                gb.setScore(s, t, score);
                myInput.nextLine();
            }
        }

        System.out.println("\n===== Results (Lowest Score Dropped) =====");
        System.out.printf("%-20s %-15s %-6s%n", "Name", "Adj. Average", "Grade");
        System.out.println("-------------------------------------");
        for (int s = 0; s < 5; s++) {
            System.out.printf("%-20s %-15.2f %-6c%n",
                gb.getName(s), gb.getAverageDropLowest(s), gb.getLetterGrade(s));
        }

        myInput.close();
    }
}
