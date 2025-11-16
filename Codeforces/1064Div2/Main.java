import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = new long[n];
            int maxIdx = 0;
            for (int i = 0; i < n; ++i) {
                a[i] = fs.nextLong();
                if (a[i] > a[maxIdx]) maxIdx = i;
            }

            // rotate so that the global maximum is at the end
            long[] b = new long[n];
            for (int i = 0; i < n; ++i) {
                b[i] = a[(maxIdx + 1 + i) % n]; // last element b[n-1] == a[maxIdx]
            }

            long ans = 0L;
            Deque<Long> st = new ArrayDeque<>();
            st.push(Long.MAX_VALUE); // sentinel
            for (int i = 0; i < n; ++i) {
                long cur = b[i];
                while (st.peek() <= cur) {
                    long mid = st.pop();
                    // when popping mid, it must be paired with the smaller of its two neighbors
                    ans += Math.min(st.peek(), cur);
                }
                st.push(cur);
            }
            // finally collapse remaining stack (except sentinel)
            while (st.size() > 2) { // sentinel + one element remain
                long mid = st.pop();
                ans += st.peek();
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }

    // fast scanner
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return val * sign;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }
}
