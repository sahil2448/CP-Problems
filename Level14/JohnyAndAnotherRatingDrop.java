
import java.io.*;

public class JohnyAndAnotherRatingDrop {

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is; // buffered input stream
        }

        private int read() throws IOException { // reads next byte, refills buffer when needed
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException { // parses next integer token
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return -1;
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

        long nextLong() throws IOException { // parses next long token
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return -1;
                }
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0L;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return sign == 1 ? val : -val;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt(); // number of test cases
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            long n = fs.nextLong(); // upper bound of the consecutive sequence [0..n]
            // For consecutive integers k -> k+1, Hamming distance is 1 + (# of trailing ones in k).
            // Summing k = 0..n-1 gives: total = 2*n - popcount(n).
            long ans = 2L * n - Long.bitCount(n); // Long.bitCount counts set bits in n
            out.append(ans).append('\n');
        }
        System.out.print(out.toString());
    }
}

/*
Time Complexity (TC): O(1)
Space Complexity (SC): O(1)
 */
