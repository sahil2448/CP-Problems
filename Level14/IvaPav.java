
import java.io.IOException;
import java.io.InputStream;

public class IvaPav {

    static int[][] pre; // pre[bit][i] = zeros count for 'bit' in a[0..i-1]
    static int[] a;
    static int n;

    static int rangeAnd(int l, int r) { // compute AND over a[l..r] from zero-counts
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            if (pre[i][r + 1] - pre[i][l] == 0) { // no zeros on bit i in [l, r]
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            pre = new int[30][n + 1]; // fresh per test case
            for (int j = 0; j < 30; j++) {
                pre[j][0] = 0;
                for (int i = 0; i < n; i++) {
                    // carry over if bit is 1, otherwise add a zero
                    if (((a[i] >> j) & 1) == 1) {
                        pre[j][i + 1] = pre[j][i];
                    } else {
                        pre[j][i + 1] = pre[j][i] + 1;
                    }
                }
            }

            int q = fs.nextInt();
            for (int qi = 0; qi < q; qi++) {
                int l = fs.nextInt() - 1; // 0-based
                int k = fs.nextInt();

                if (a[l] < k) { // AND is non-increasing; cannot reach k if a[l] < k
                    out.append("-1 ");
                    continue;
                }

                int low = l, high = n - 1; // binary search max r
                while (low < high) {
                    int mid = (low + high + 1) >>> 1; // bias right
                    if (rangeAnd(l, mid) >= k) {
                        low = mid; // feasible, extend
                    } else {
                        high = mid - 1; // infeasible, shrink

                    }
                }
                out.append(low + 1).append(' '); // back to 1-based
            }
            out.append('\n');
        }

        System.out.print(out.toString());
    }

    // Fast scanner for large input
    static final class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}

/*
Time Complexity (TC): O(n * logA + q * logn * logA)
Space Complexity (SC): O(n * logA)
 */
