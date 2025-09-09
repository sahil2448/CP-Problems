
import java.util.*;

public class SubsequenceAdditio_easy {

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        if (a[0] != 1) {
            System.out.println("NO");
            return;
        }

        boolean[] dp = new boolean[5005];
        dp[1] = true;

        for (int i = 1; i < n; i++) {
            int cur = a[i];

            if (!dp[cur]) {
                System.out.println("NO");
                return;
            }

            for (int sum = 5000; sum >= cur; sum--) {
                dp[sum] |= dp[sum - cur];
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
