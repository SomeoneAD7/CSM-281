public class PassChecker {
    public static void main(String[] args) {
        boolean hasPassed = false; 
        boolean paidFees = false; 
        int fees = 10;  // fees must be 100 to get a cert. 
        boolean repeated = false; 
        int exam = 23; 
        int assessment = 47; 
        int total = exam + assessment; 

        System.out.println("Your total mark is : " + total + "\nYou got " + exam + " in your exams and " + assessment + " in your assessment. "); 
        System.out.println();  

        if (exam >= 25 && assessment >= 15) {
            hasPassed = true; 
            //repeated = false; 
            System.out.println("Congratulations, you have passed. "); 
        } 

        else if ((exam >= 25 && assessment >= 14) || (exam >= 24 && assessment >= 15)) {
            System.out.println("You are condoned. "); 
            //repeated = false; 
            hasPassed = true; 
        } 

        else {
            System.out.println("Sorry but you have failed. "); 
            //System.out.println(); 
            if (exam <= 24 && assessment >= 15) {
                System.out.println("You failed the exam and passed the assessment. "); 
            } 

            else if (exam >= 25 && assessment <= 14) {
                System.out.println("You passed the exam and failed the assessment."); 
            } 

            else {
                System.out.println("You failed both the exams and assessment. \nYou have therefore been repeated.");  
                repeated = true; 
            }
        } 

        System.out.println(); 

        if (hasPassed) {
            if (fees >= 100) {
                paidFees = true; 
                // System.out.println(); 
                System.out.println("You have paid all your fees. Well done."); 
            } 
            else {
                paidFees = false; 
                System.out.println("You have not paid all your fees. Pay all before you can recieve your cert. "); 
            }

        } 

        if (paidFees && hasPassed && !repeated) { 
            System.out.println("Here is your cert. \nAll the best in life.");  
        } 

        System.out.println(); 
        System.out.println(); 
        System.out.println(); 

        double num = 10; 
        System.out.println(num *= 1.15); 


    }
}