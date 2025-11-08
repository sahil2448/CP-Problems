
import java.util.*;

public class SubsetMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long ans = 1L;
            for (int i = 1; i < n; i++) {
                if (a[i] % a[i - 1] != 0) {
                    long g = gcd(a[i], a[i - 1]);
                    long val = a[i - 1] / g;
                    ans = lcm(ans, val);
                }
            }

            out.append(ans).append("\n");
        }

        System.out.print(out.toString());
    }

    static long gcd(long x, long y) {
        while (y != 0) {
            long tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    static long lcm(long x, long y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        return x / gcd(x, y) * y;
    }
}
