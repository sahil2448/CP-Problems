
import java.util.*;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextLong();
            }

            long numerator = (long) n * a[1] - a[n];
            long denomerator = (long) n * n - 1;

            if (numerator < 0 || numerator % denomerator != 0) {
                System.out.println("NO");
                continue;
            }

            long y = numerator / denomerator;
            long x = a[1] - (long) n * y;

            if (x < 0) {
                System.out.println("NO");
                continue;
            }

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                long expected = x * i + y * (n - i + 1L);
                if (expected != a[i]) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
