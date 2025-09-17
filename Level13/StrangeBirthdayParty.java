
import java.io.*;
import java.util.*;

public class StrangeBirthdayParty {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int[] k = new int[n];
            long[] c = new long[m];

            for (int i = 0; i < n; i++) {
                k[i] = fs.nextInt();
            }
            for (int i = 0; i < m; i++) {
                c[i] = fs.nextLong();
            }

            Arrays.sort(k);

            long ans = 0;
            int p = 0;

            for (int i = n - 1; i >= 0; i--) {
                int want = k[i] - 1;
                if (p < m && c[p] < c[want]) {
                    ans += c[p];
                    p++;
                } else {
                    ans += c[want];
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }

    // Fast input reader
    static class FastScanner {

        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return Integer.MIN_VALUE;
                }
            }
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

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return Long.MIN_VALUE;
                }
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
