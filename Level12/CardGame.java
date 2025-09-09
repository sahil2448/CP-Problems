
import java.util.*;

public class CardGame {

    static boolean beats(int n, int x, int y) {
        // x beats y?
        if (x == 0) {
            return y == n - 1;   // 1 beats n

        }
        if (x == n - 1) {
            return y != 0;   // n beats everyone except 1

        }
        return x > y;                    // normal order
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            String owner = sc.next();
            boolean aliceWins = false;

            for (int i = 0; i < n && !aliceWins; i++) {
                if (owner.charAt(i) != 'A') {
                    continue;
                }
                boolean safe = true;
                for (int j = 0; j < n; j++) {
                    if (owner.charAt(j) == 'B' && beats(n, j, i)) {
                        safe = false;
                        break;
                    }
                }
                if (safe) {
                    aliceWins = true;
                }
            }
            out.append(aliceWins ? "Alice" : "Bob").append('\n');
        }

        System.out.print(out.toString());
    }
}
