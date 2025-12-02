
import java.io.*;

public class MakeItRound {

    static long[] p2 = new long[19];
    static long[] p5 = new long[19];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        p2[0] = 1;
        p5[0] = 1;
        for (int i = 1; i <= 18; i++) {
            p2[i] = 2L * p2[i - 1]; // 2^i
            p5[i] = 5L * p5[i - 1]; // 5^i
        }

        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
            long m = fs.nextLong();

            int c2 = 0, c5 = 0; // counts of factor 2 and 5 in n

            long temp = n;
            while (temp % 2 == 0) { // remove all 2s from n
                c2++;
                temp /= 2;
            }
            temp = n;
            while (temp % 5 == 0) { // remove all 5s from n
                c5++;
                temp /= 5;
            }

            for (int dig = 18; dig >= 0; dig--) {
                int extra2 = Math.max(0, dig - c2); // extra 2s needed from k
                int extra5 = Math.max(0, dig - c5); // extra 5s needed from k

                long need = p2[extra2] * p5[extra5]; // minimal factor that ensures at least 'dig' trailing zeros
                if (need <= m) {
                    long largestK = m - (m % need); // largest k <= m divisible by 'need' to maximize n*k
                    out.append(largestK * n).append('\n');
                    break;
                }
            }
        }

        System.out.print(out.toString());
    }

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

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= 32);
            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sgn;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    // Time Complexity (TC): O(t)
    // Space Complexity (SC): O(1)
}
