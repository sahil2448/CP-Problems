
import java.io.*;
import java.util.*;

public class Pride {

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
            int c, s = 1, x = 0;
            do {
                c = read();
            } while (c <= ' ');
            if (c == '-') {
                s = -1;
                c = read();
            }
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * s;
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt(); // read array a of size n
        }
        int g = a[0];
        int cnt = 0; // count how many elements are already 1
        for (int x : a) {
            g = gcd(g, x); // gcd of the entire array
            if (x == 1) {
                cnt++;
            }
        }

        if (g > 1) { // if overall gcd > 1, it's impossible to reach all 1's
            System.out.println(-1);
            return;
        }

        if (cnt > 0) { // at least one 1 exists; each non-1 needs one operation
            System.out.println(n - cnt);
            return;
        }

        int ans = 2 * n; // large initial value (upper bound placeholder)
        // Find the shortest subarray with gcd == 1. If subarray [i..j] has gcd 1,
        // it takes (j - i) ops to create a single 1, then (n - 1) to spread it.
        for (int i = 0; i < n; i++) {
            int gc = a[i];
            for (int j = i + 1; j < n; j++) {
                gc = gcd(gc, a[j]); // progressive gcd of a[i..j]
                if (gc == 1) { // found minimal j for this i
                    ans = Math.min(ans, (n - 1) + (j - i));
                    break; // no need to extend further for this i
                }
            }
        }

        System.out.println(ans);
    }
}

/*
Time Complexity (TC): O(n^2*log(ai))
Space Complexity (SC): O(n)
 */
