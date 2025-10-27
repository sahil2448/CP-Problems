
import java.io.*;
import java.util.*;

public class E {

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
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
    }

    public static void solve(FastScanner fs, StringBuilder out) throws IOException {
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }

        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            s.add(i);
        }
        for (int i = 0; i < n; i++) {
            s.remove(a[i]);
        }

        if (s.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i > 0) {
                    out.append(' ');
                }
                out.append(a[i]);
            }
            out.append('\n');
            return;
        }

        int o = s.first();

        s.clear();
        for (int i = 1; i <= n; i++) {
            s.add(i);
        }

        s.remove(o);
        s.remove(a[n - 1]);

        out.append(o);
        out.append(' ');

        for (int i = 0; i < k - 1; i++) {
            if (!s.isEmpty()) {
                int val = s.first();
                out.append(val);
                if (i != k - 2) {
                    out.append(' ');
                }
                s.remove(val);
            } else {
                out.append(a[n - 1]);
                if (i != k - 2) {
                    out.append(' ');
                }
            }
        }
        out.append('\n');
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs, out);
        }
        System.out.print(out.toString());
    }
}
