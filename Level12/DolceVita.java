
import java.util.*;

public class DolceVita {

    private static int lastInvite(long[] preSum, long x, long day) {
        int low = 0, high = preSum.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (preSum[mid] + (mid + 1) * day <= x) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);

            long[] preSum = new long[n];
            preSum[0] = a[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + a[i];
            }

            long ans = 0;
            long day = 0;
            while (true) {
                int k = lastInvite(preSum, x, day);
                if (k < 0) {
                    break;
                }

                long maxDay = (x - preSum[k]) / (k + 1);

                long daysCount = maxDay - day + 1;

                ans += daysCount * (k + 1);

                day = maxDay + 1;
            }

            System.out.println(ans);
        }
    }
}
