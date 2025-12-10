
import java.io.*;

public class AndSequences {

    static final int N = 200000; 
    static final long MOD = 1_000_000_007L; 
    static final long[] fact = new long[N + 1]; 

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            int totalAnd = a[0];
            for (int i = 1; i < n; i++) {
                totalAnd &= a[i];
            }

            int countAnd = 0;
            for (int x : a) {
                if (x == totalAnd) {
                    countAnd++;

                            }}

            if (countAnd <= 1) {
                out.append(0).append('\n'); 
                continue;
            }

            long ways = (countAnd * 1L * (countAnd - 1)) % MOD; 
            ways = (ways * fact[n - 2]) % MOD; 
            out.append(ways).append('\n');
        }

        System.out.print(out.toString());
    }

    static final class FastScanner {

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
            do {
                c = read();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sgn;
        }
    }
}
