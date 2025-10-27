
import java.io.*;
import java.util.*;

public class ScoringSubsequences {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
            for (int i = 0; i < n; i++) {
                int a = fs.nextInt();
                pq.add(a);
                while (!pq.isEmpty() && pq.peek() < pq.size()) {
                    pq.poll();
                }
                out.append(pq.size());
                if (i + 1 < n) {
                    out.append(' ');
                }
            }
            out.append('\n');
        }
        System.out.print(out.toString());
    }

    static class FastScanner {

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
}
