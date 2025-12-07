
import java.io.*;

public class FortuneTelling {

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

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
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

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
            long x = fs.nextLong();
            long y = fs.nextLong();

            int numOdds = 0;
            for (int i = 0; i < (int) n; i++) {
                long ai = fs.nextLong();
                if ((ai & 1L) == 1L) {
                    numOdds++;
                }
            }

            int aliceStart = (int) (x & 1L);
            int bobStart = 1 - aliceStart;

            int aliceEnd, bobEnd;
            if ((numOdds & 1) == 0) {
                aliceEnd = aliceStart;
                bobEnd = bobStart;
            } else {
                aliceEnd = 1 - aliceStart;
                bobEnd = 1 - bobStart;
            }

            if (((int) (y & 1L)) == aliceEnd) {
                out.append("Alice\n");
            } else {
                out.append("Bob\n");
            }
        }

        System.out.print(out.toString());
    }
}

/*
Time Complexity (TC): O(n)
Space Complexity (SC): O(1)
 */
