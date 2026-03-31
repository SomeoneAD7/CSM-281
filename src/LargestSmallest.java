import java.util.*;

public class LargestSmallest {
    public static void  main(String[] args){
        Scanner myInput = new Scanner(System.in); 
        ArrayList<Integer> nums = new ArrayList<Integer>();

        System.out.print("Enter an integer : "); 
        nums.add(myInput.nextInt()); 

        while(nums.get(nums.size() - 1) != -99){
            System.out.print("Enter an integer : "); 
            nums.add(myInput.nextInt()); 
        } 

        nums.remove(nums.size() - 1); // this is to remove the -99 from the list of numbers entered by the user. 
        if (nums.isEmpty()) {
            System.out.println("No valid numbers were entered.");
            return;
        }
        Collections.sort(nums); 
        System.out.println(); 
        System.out.println("The smallest number entered is " + nums.get(0));
        System.out.println("The largest number entered is " + nums.get(nums.size() - 1)); 
    }
}
