import java.util.*;

public class ThousandsOfTONSofTNT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] pref = new long[n + 1];

            Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                set.add(val);
                pref[i + 1] = pref[i] + val;
            }

            if (set.size() == 1) {
                out.append(0).append('\n');
                continue;
            }

            long ans = 0;

            for (int k = 1; k <= n / 2; k++) {
                if (n % k != 0) {
                    continue;
                }

                long localMin = Long.MAX_VALUE;
                long localMax = Long.MIN_VALUE;
                for (int start = 0; start + k <= n; start += k) {
                    long sum = pref[start + k] - pref[start];
                    if (sum < localMin) localMin = sum;
                    if (sum > localMax) localMax = sum;
                }

                long diff = localMax - localMin;
                if (diff > ans) ans = diff;
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
        sc.close();
    }
}
