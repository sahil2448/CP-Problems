import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        for (int j = 0; j < t; j++) {
            int n = sc.nextInt(); // Number of cows
            int m = sc.nextInt(); // Cards per cow
            int[][] cards = new int[n][m + 1]; // Stores each cow's cards and their index

            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    cards[i][k] = sc.nextInt(); // Read cards
                }
                Arrays.sort(cards[i], 0, m); // Sort cards for each cow
                cards[i][m] = i + 1; // Store cow's original index for output
            }

            // Sort cows based on their smallest card
            Arrays.sort(cards, Comparator.comparingInt(a -> a[0]));

            int topCard = -1; // The card on top of the center pile
            boolean valid = true;

            // Simulate the game
            for (int round = 0; round < m; round++) {
                for (int i = 0; i < n; i++) {
                    boolean played = false;
                    for (int k = 0; k < m; k++) {
                        if (cards[i][k] > topCard) {
                            topCard = cards[i][k]; // Play this card
                            cards[i][k] = -1; // Mark card as used
                            played = true;
                            break;
                        }
                    }
                    if (!played) {
                        valid = false; // If a cow cannot play, the game is invalid
                        break;
                    }
                }
                if (!valid) break;
            }

            if (valid) {
                // Print the order of cows (1-based index)
                for (int i = 0; i < n; i++) {
                    System.out.print(cards[i][m] + " ");
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
