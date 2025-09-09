
import java.util.*;

public class BalancedRound {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextInt();
            long k = sc.nextLong();
            long[] arr = new long[(int) n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            if (n == 1) {
                System.out.println(0);
                continue;
            }

            Arrays.sort(arr);
            long maxLen = 0;
            long len = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[i - 1] <= k) {
                    len++;
                } else {
                    maxLen = Math.max(maxLen, len);
                    len = 1;
                }
            }
            maxLen = Math.max(maxLen, len);

            System.out.println(n - maxLen);
        }
    }
}
