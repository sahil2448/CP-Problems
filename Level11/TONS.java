
import java.util.*;

public class TONSofTN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        long[] v = new long[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextLong();
        }

        long[] pre = new long[n];
        pre[0] = v[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + v[i];
        }

        long ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            int idx = k - 1;
            long maxi = pre[idx];
            long mini = pre[idx];

            for (int j = idx + k; j < n; j += k) {
                long curr = pre[j] - pre[j - k];
                if (curr > maxi) {
                    maxi = curr;
                }
                if (curr < mini) {
                    mini = curr;
                }
            }

            long diff = maxi - mini;
            if (diff > ans) {
                ans = diff;
            }
        }

        System.out.println(ans);
    }
}
