
import java.io.*;
import java.util.*;

public class TilingCorridors {

    static final long MOD = 1_000_000_007L;

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

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            long sign = 1;
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

    static long power(long x, long k) {
        long ret = 1;
        x %= MOD;

        while (k > 0) {
            if ((k & 1) == 1) {
                ret = (ret * x) % MOD;
            }
            x = (x * x) % MOD;
            k >>= 1;
        }
        return ret;
    }

    static long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        int m = A[0].length;
        int k = B[0].length;

        long[][] C = new long[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                long sum = 0;
                for (int l = 0; l < m; l++) {
                    sum = (sum + (A[i][l] * B[l][j]) % MOD) % MOD;
                }
                C[i][j] = sum;
            }
        }
        return C;
    }

    static long[][] power(long[][] A, long k) {
        int n = A.length;
        long[][] ret = new long[n][n];
        long[][] B = A;

        for (int i = 0; i < n; i++) {
            ret[i][i] = 1;
        }

        while (k > 0) {
            if ((k & 1) == 1) {
                ret = multiply(ret, B);
            }
            B = multiply(B, B);
            k >>= 1;
        }
        return ret;
    }

    static long chocolateWays(long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        long[][] M = {
            {2, 0, 1},
            {1, 0, 0},
            {0, 0, 0}
        };

        long[][] P = power(M, n - 2);

        long f2 = 2, f1 = 1, f0 = 1;
        long ans = 0;

        ans = (ans + P[0][0] * f2) % MOD;
        ans = (ans + P[0][1] * f1) % MOD;
        ans = (ans + P[0][2] * f0) % MOD;
        // this ans variable is storing the value of Fn (first row after multiplying 3X3 matrix(P matrix) with 3X1 matrix);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        long n = fs.nextLong();
        System.out.println(chocolateWays(n));
    }
}
