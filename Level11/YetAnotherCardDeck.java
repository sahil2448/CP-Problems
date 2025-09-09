
import java.util.*;

public class YetAnotherCardDeck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        final int MAX_COLOUR = 50;
        int[] first = new int[MAX_COLOUR + 1];
        Arrays.fill(first, Integer.MAX_VALUE);

        for (int idx = 1; idx <= n; idx++) {
            int colour = sc.nextInt();
            if (first[colour] == Integer.MAX_VALUE) {
                first[colour] = idx;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int c = sc.nextInt();
            int old = first[c];

            sb.append(old).append(' ');
            for (int col = 1; col <= MAX_COLOUR; col++) {
                if (first[col] < old) {
                    first[col]++;

                }
            }
            first[c] = 1;
        }

        System.out.println(sb.toString().trim());
    }
}
