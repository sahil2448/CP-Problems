
import java.util.*;

public class RudolfAndSnowflakes {

    static HashSet<Long> set = new HashSet<>();

    public static boolean precompute(long n) {

        for (long k = 2; k <= 1000; k++) {
            long val = k + 1;
            long p = k * k;
            if (val > 1e6) {
                break;
            }

            for (int cnt = 2; cnt <= 20; ++cnt) {
                val += p;
                if (val > 1e6) {
                    break;
                }
                set.add(val);
                p *= k;
            }
        }

        return set.contains(n);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            if (precompute(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
