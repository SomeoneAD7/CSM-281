// Write a progranm taht uses for loop to display price of items in a shopping cart. 
// 1. Sytore the prices pf the 5 iyems in a double array. 
// 2. use a for loop to loop through each item in array.
// 3. displau each items number and price
// 4. if > 100, 10% discount  and indicate that discount has been applied. 
// 5. calc total amount after discounts 

public class ShoppingCart {
    public static void main(String[] args) {
        double[] itemPrices = {50.6, 58.9, 388.5, 297.5, 100.0};
        double totalPrice = 0.0; 

        for (int i = 0; i < itemPrices.length; i++) {
            double currentPrice = itemPrices[i]; 
            
            if (currentPrice > 100) {
                double discountPrice = 0.9 * currentPrice; 
                currentPrice = discountPrice; 
            } 

            
        }
    }
}