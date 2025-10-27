
import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long[] pref = new long[n];
            long cur = 0;
            for (int i = 0; i < n; i++) {
                cur = Math.max(cur, a[i]);
                pref[i] = cur;
            }

            long ans = 0L;
            for (int j = 0; j < n; j += 2) { 
                long left = (j > 0) ? pref[j - 1] : Long.MAX_VALUE;
                long right = (j + 1 < n) ? pref[j + 1] : Long.MAX_VALUE;
                long limit = Math.min(left, right);
                long need = Math.max(0L, a[j] - limit + 1L);
                ans += need;
            }
            out.append(ans).append('\n');
        }
        System.out.print(out.toString());
    }
}
