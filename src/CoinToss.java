import java.util.Random;

class Coin {
    private String sideUp;
    private Random rand = new Random();

    public Coin() {
        toss();
    }

    public void toss() {
        int result = rand.nextInt(2);
        if (result == 0) {
            sideUp = "heads";
        } else {
            sideUp = "tails";
        }
    }

    public String getSideUp() {
        return sideUp;
    }
}

public class CoinToss {
    public static void main(String[] args) {
        Coin coin = new Coin();

        System.out.println("===== Coin Toss Simulator =====");
        System.out.println("Initial side facing up: " + coin.getSideUp());
        System.out.println("\nTossing 20 times...\n");

        int headsCount = 0;
        int tailsCount = 0;

        for (int i = 1; i <= 20; i++) {
            coin.toss();
            String result = coin.getSideUp();
            System.out.printf("Toss %2d: %s%n", i, result);

            if (result.equals("heads")) headsCount++;
            else tailsCount++;
        }

        System.out.println("\n===== Results =====");
        System.out.println("Heads : " + headsCount);
        System.out.println("Tails : " + tailsCount);
    }
}
