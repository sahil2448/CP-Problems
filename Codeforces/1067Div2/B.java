
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int total = 2 * n;
            int[] freq = new int[total + 1];

            for (int i = 0; i < total; i++) {
                int x = sc.nextInt();
                freq[x]++;
            }

            int distinctOdds = 0;
            int distinctEvens = 0;
            for (int v = 1; v <= total; v++) {
                if (freq[v] == 0) {
                    continue;
                }
                if (freq[v] % 2 == 1) {
                    distinctOdds++;
                } else {
                    distinctEvens++;
                }
            }

            int twoEven = Math.min(distinctEvens, n);
            if (distinctOdds == 0 && (twoEven % 2) != (n % 2)) {
                if (twoEven > 0) {
                    twoEven--;
                }

            }

            int ans = distinctOdds + 2 * twoEven;
            System.out.println(ans);
        }
    }
}
