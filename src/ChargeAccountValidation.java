import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class ChargeAccountFileValidator {
    private ArrayList<Integer> validAccounts = new ArrayList<>();

    public ChargeAccountFileValidator(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileSc = new Scanner(file);
        while (fileSc.hasNextInt()) {
            validAccounts.add(fileSc.nextInt());
        }
        fileSc.close();
    }

    public boolean isValid(int accountNumber) {
        for (int acc : validAccounts) {
            if (acc == accountNumber) return true;
        }
        return false;
    }
}

public class ChargeAccountValidation {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("===== Charge Account Validation (File-Based) =====");

        ChargeAccountFileValidator validator;
        try { // This checks if the file exists and can be read. If not, it prints an error message and exits.
            validator = new ChargeAccountFileValidator("charge_accounts.txt");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: 'charge_accounts.txt' not found.");
            System.out.println("Please create a text file named 'charge_accounts.txt' with one account number per line.");
            myInput.close();
            return;
        }

        int accountNum = 0;
        while (accountNum <= 0) {
            System.out.print("Enter your charge account number: ");
            if (myInput.hasNextInt()) {
                accountNum = myInput.nextInt();
                if (accountNum <= 0) System.out.println("  !! Must be a positive number.");
            } else {
                System.out.println("  !! Invalid input.");
                myInput.next();
            }
        }

        if (validator.isValid(accountNum)) {
            System.out.println("Account " + accountNum + ": VALID");
        } else {
            System.out.println("Account " + accountNum + ": INVALID");
        }

        myInput.close();
    }
}
