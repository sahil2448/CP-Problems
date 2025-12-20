
import java.io.*;

public class C {

    static class FastScanner {

        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
            do {
                c = readByte();
            } while (c <= ' ');

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

    static final long INF = 1_000_000_000_000_000L;

    static void solve(FastScanner fs, StringBuilder out) throws Exception {
        int n = fs.nextInt();
        long[] a = new long[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
        }

        a[n] = INF;

        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = a[i + 1] - a[i];
        }

        long low = 0, high = d[0];
        long ans = 0;

        for (int i = 1; i < n; i++) {
            long nl = d[i - 1] - high;
            long nh = d[i - 1] - low;
            nh = Math.min(nh, d[i]);

            if (nl >= d[i]) {
                nl = 0;
            } else {
                ans++;
            }

            low = nl;
            high = nh;
        }

        out.append(ans).append('\n');
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs, out);
        }

        System.out.print(out.toString());
    }
}
