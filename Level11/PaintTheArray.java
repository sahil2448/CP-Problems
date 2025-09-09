import java.util.*;

public class PaintTheArray {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        long[] g = { a[0], (n > 1 ? a[1] : 0) };
        for (int i = 0; i < n; i++) {
            g[i % 2] = gcd(g[i % 2], a[i]);
        }

        boolean[] good = { true, true };
        for (int i = 0; i < n; i++) {
            if (a[i] % g[(i % 2) ^ 1] == 0) {
                good[i % 2] = false;
            }
        }

        long ans = 0;
        for (int i = 0; i < 2; i++) {
            if (good[i]) {
                ans = Math.max(ans, g[i ^ 1]);
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }
}
