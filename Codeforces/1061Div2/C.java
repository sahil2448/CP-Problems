
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] cnt = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (num <= n) {
                    cnt[num]++;
                }
            }
            int[] prefixSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + cnt[i];
            }
            int ans = 1;
            for (int d = n; d >= 2; d--) {
                int T = Math.min(4 * d - 1, n);
                int multiples = cnt[d];
                if (2 * d <= n) {
                    multiples += cnt[2 * d];
                }
                if (3 * d <= n) {
                    multiples += cnt[3 * d];
                }
                if (prefixSum[T] - multiples <= k) {
                    ans = d;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
