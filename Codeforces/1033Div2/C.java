
import java.util.*;

public class C {

    // --- optional: identical helper kept from the original code -------------
    static String toBinary30(long x) {          // 30-bit left-padded binary
        char[] buf = new char[30];
        for (int i = 29; i >= 0; --i) {
            buf[i] = (char) ('0' + (x & 1));
            x >>= 1;
        }
        return new String(buf);
    }
    // -----------------------------------------------------------------------

    private static void solve(Scanner sc) {
        long n = sc.nextLong();
        long m = sc.nextLong();

        long mn = n;                   // smallest possible sum of distances
        long mx = n * (n + 1) / 2;     // largest  possible sum of distances
        if (m < mn || m > mx) {
            System.out.println(-1);
            return;
        }

        // binary search for the root depth (rt) ------------------------------
        long l = 1, h = n;
        while (l < h) {
            long mid = (l + h) / 2;
            long s2 = (n - mid) * mid;
            long s1 = mid * (mid + 1) / 2;
            if (s2 + s1 < m) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        long rt = l;

        long minPossible = rt * (rt - 1) / 2 + (n - rt + 1);
        if (minPossible > m) {
            System.out.println(-1);
            return;
        }

        // number of extra distance units that still have to be “removed”
        long r = (n - rt) * rt - m + rt * (rt + 1) / 2;

        /* ------------------------------------------------------------------
           The tree has exactly n-1 edges; store them in two parallel arrays.
           Positions are filled sequentially (idx pointer).
        ------------------------------------------------------------------ */
        int edgeCnt = (int) (n - 1);
        long[] eu = new long[edgeCnt];
        long[] ev = new long[edgeCnt];
        int idx = 0;

        /* 1) connect vertices 1 … rt-1 directly to the chosen root `rt` */
        for (long u = 1; u < rt; ++u) {
            eu[idx] = rt;
            ev[idx] = u;
            ++idx;
        }

        /* 2) connect remaining vertices rt+1 … n */
        for (long v = n; v > rt; --v) {
            if (r > 0) {                       // need to shorten total length
                long d = Math.min(r, rt - 1);  // how much can be shortened
                long u = rt - d;               // shall attach a shallower node
                eu[idx] = u;
                ev[idx] = v;
                ++idx;
                r -= d;
            } else {                           // simplest: hook to root
                eu[idx] = rt;
                ev[idx] = v;
                ++idx;
            }
        }

        // -------- output ----------------------------------------------------
        System.out.println(rt);
        for (int i = 0; i < idx; ++i) {
            System.out.println(eu[i] + " " + ev[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // allowed: not part of java.io
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }
}
