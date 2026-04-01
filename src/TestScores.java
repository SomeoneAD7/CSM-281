import java.util.Scanner;

class TestScoresClass {
    private double score1;
    private double score2;
    private double score3;

    public TestScoresClass(double score1, double score2, double score3) {
        setScore1(score1);
        setScore2(score2);
        setScore3(score3);
    }

    public double getScore1() { return score1; }
    public double getScore2() { return score2; }
    public double getScore3() { return score3; }

    public void setScore1(double s) {
        if (s < 0 || s > 100) throw new IllegalArgumentException("Score must be between 0 and 100.");
        this.score1 = s;
    }
    public void setScore2(double s) {
        if (s < 0 || s > 100) throw new IllegalArgumentException("Score must be between 0 and 100.");
        this.score2 = s;
    }
    public void setScore3(double s) {
        if (s < 0 || s > 100) throw new IllegalArgumentException("Score must be between 0 and 100.");
        this.score3 = s;
    }

    public double getAverage() {
        return (score1 + score2 + score3) / 3.0;
    }
}

public class TestScores {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("===== Test Score Averager =====");
        double s1 = getScore(myInput, "Enter Test Score 1 (0 - 100): ");
        double s2 = getScore(myInput, "Enter Test Score 2 (0 - 100): ");
        double s3 = getScore(myInput, "Enter Test Score 3 (0 - 100): ");

        TestScoresClass ts = new TestScoresClass(s1, s2, s3);
        System.out.printf("%nAverage test score: %.2f%n", ts.getAverage());
    }

    static double getScore(Scanner myInput, String prompt) {
        double val = -1;
        while (val < 0 || val > 100) {
            System.out.print(prompt);
            if (myInput.hasNextDouble()) {
                val = myInput.nextDouble();
                if (val < 0 || val > 100) System.out.println("  !! Score must be between 0 and 100.");
            } else {
                System.out.println("  !! Invalid input.");
                myInput.next();
            }
        }
        return val;
    }
}
