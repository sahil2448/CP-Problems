
import java.util.*;

public class TwoDTravelling {

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();

        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        long ans = Math.abs(x[s] - x[t]) + Math.abs(y[s] - y[t]);
        long mins = (long) 1e17, mint = (long) 1e17;

        for (int i = 1; i <= k; i++) {
            mins = Math.min(mins, Math.abs(x[s] - x[i]) + Math.abs(y[s] - y[i]));
            mint = Math.min(mint, Math.abs(x[t] - x[i]) + Math.abs(y[t] - y[i]));
        }

        ans = Math.min(ans, mins + mint);
        System.out.println(ans);
        // T.C :- O(n)
        // S.C :- O(n)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
