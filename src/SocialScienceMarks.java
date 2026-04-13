class Input {

    private String[] indexNumbers = {
        "10021007", "10021107", "10021207", "10021307", "10021407",
        "10021507", "10021607", "10021707", "10021807", "10021907",
        "10022007", "10022107", "10022207", "10022307", "10022407"
    };

    private double[] midSemScores = {
        65, 48, 22, 32, 80,
        12, 45, 25, 33, 67,
        23, 45, 56, 34, 81
    };

    private double[] examScores = {
        78, 54, 90, 32, 66,
        60, 48, 65, 45, 56,
        33, 45, 67, 90, 67
    };

    public String[] getIndexNumbers()  { return indexNumbers; }
    public double[] getMidSemScores()  { return midSemScores; }
    public double[] getExamScores()    { return examScores; }
    public int getNumberOfStudents()   { return indexNumbers.length; }
}

class Processing {
    private Input input;

    private double[] finalScores;
    private char[]   grades;

    private int countA;
    private int countB;
    private int countC;
    private int countD;
    private int countE;
    private int countF;

    private double average;
    private double maximum;
    private double minimum;

    public Processing(Input input) {
        this.input = input;
        int n = input.getNumberOfStudents();

        finalScores = new double[n];
        grades      = new char[n];

        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;
        countE = 0;
        countF = 0;
    }

    private double computeFinalScore(double midSem, double exam) {
        double midContribution  = (midSem / 100.0) * 30.0;
        double examContribution = (exam   / 100.0) * 70.0;
        return midContribution + examContribution;
    }

    private char assignGrade(double finalScore) {
        if (finalScore >= 80) {
            return 'A';
        } else if (finalScore >= 70) {
            return 'B';
        } else if (finalScore >= 60) {
            return 'C';
        } else if (finalScore >= 50) {
            return 'D';
        } else if (finalScore >= 40) {
            return 'E';
        } else {
            return 'F';
        }
    }

    private void updateGradeCount(char grade) {
        if (grade == 'A') {
            countA = countA + 1;
        } else if (grade == 'B') {
            countB = countB + 1;
        } else if (grade == 'C') {
            countC = countC + 1;
        } else if (grade == 'D') {
            countD = countD + 1;
        } else if (grade == 'E') {
            countE = countE + 1;
        } else {
            countF = countF + 1;
        }
    }

    public void processAll() {
        double[] midSems = input.getMidSemScores();
        double[] exams   = input.getExamScores();
        int n            = input.getNumberOfStudents();

        double total = 0;
        maximum = -1;
        minimum = 101;

        for (int i = 0; i < n; i++) {
            double finalScore = computeFinalScore(midSems[i], exams[i]);
            char   grade      = assignGrade(finalScore);

            finalScores[i] = finalScore;
            grades[i]      = grade;

            updateGradeCount(grade);

            total = total + finalScore;

            if (finalScore > maximum) {
                maximum = finalScore;
            }
            if (finalScore < minimum) {
                minimum = finalScore;
            }
        }

        average = total / n;
    }

    public double[] getFinalScores() { return finalScores; }
    public char[]   getGrades()      { return grades; }
    public int      getCountA()      { return countA; }
    public int      getCountB()      { return countB; }
    public int      getCountC()      { return countC; }
    public int      getCountD()      { return countD; }
    public int      getCountE()      { return countE; }
    public int      getCountF()      { return countF; }
    public double   getAverage()     { return average; }
    public double   getMaximum()     { return maximum; }
    public double   getMinimum()     { return minimum; }
}


class Output {

    private Input      input;
    private Processing processing;

    public Output(Input input, Processing processing) {
        this.input      = input;
        this.processing = processing;
    }

    public void displayAll() {

        String[] indexNos    = input.getIndexNumbers();
        double[] midSems     = input.getMidSemScores();
        double[] exams       = input.getExamScores();
        double[] finalScores = processing.getFinalScores();
        char[]   grades      = processing.getGrades();
        int      n           = input.getNumberOfStudents();

        System.out.println("=======================================================");
        System.out.println("      COMPUTER SCIENCE DEPARTMENT, KNUST");
        System.out.println("      CSM 184 INTRODUCTION TO COMPUTER II");
        System.out.println("=======================================================");
        System.out.printf("%-5s %-12s %-10s %-10s %-10s %-6s%n",
            "S/N", "INDEX NO", "MID SEM", "EXAM", "FINAL", "GRADE");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d %-12s %-10.1f %-10.1f %-10.2f %-6c%n",
                i + 1,
                indexNos[i],
                midSems[i],
                exams[i],
                finalScores[i],
                grades[i]);
        }

        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("===== Grade Frequency =====");
        System.out.printf("%-8s %-10s%n", "GRADE", "NUMBER");
        System.out.println("------------------");
        System.out.printf("%-8s %-10d%n", "A", processing.getCountA());
        System.out.printf("%-8s %-10d%n", "B", processing.getCountB());
        System.out.printf("%-8s %-10d%n", "C", processing.getCountC());
        System.out.printf("%-8s %-10d%n", "D", processing.getCountD());
        System.out.printf("%-8s %-10d%n", "E", processing.getCountE());
        System.out.printf("%-8s %-10d%n", "F", processing.getCountF());
        System.out.println("------------------");
        System.out.println();
        System.out.println("===== Statistics =====");
        System.out.printf("Average Score : %.2f%n", processing.getAverage());
        System.out.printf("Maximum Score : %.2f%n", processing.getMaximum());
        System.out.printf("Minimum Score : %.2f%n", processing.getMinimum());
    }
}

public class SocialScienceMarks {
    public static void main(String[] args) {

        // Step 1: Load all input data
        Input input = new Input();

        // Step 2: Process the data
        Processing processing = new Processing(input);
        processing.processAll();

        // Step 3: Display all results
        Output output = new Output(input, processing);
        output.displayAll();
    }
}