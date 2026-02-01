
import java.io.*;

public class C {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }

            long base = 0;
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    base += a[i];
                } else {
                    base -= a[i];
                }
            }

            long ans = base;

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, base + i - (i & 1));
            }

            long INF = (long) 4e18;
            long minEven = INF;
            long minOdd = INF;

            for (int i = 0; i < n; i++) {
                if ((i & 1) == 1) {
                    ans = Math.max(ans, base + i + 2 * a[i] - minEven);
                    minOdd = Math.min(minOdd, i - 2 * a[i]);
                } else {
                    ans = Math.max(ans, base + i - 2 * a[i] - minOdd);
                    minEven = Math.min(minEven, i + 2 * a[i]);
                }
            }

            System.out.println(ans);
        }

    }

    static class FastScanner {

        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') {
                if (c == -1) {
                    return Long.MIN_VALUE;
                }
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
