
import java.util.*;

public class BuildingAnAquarium {

    public static long calcTotal(long maxH, long[] a, int n) {
        long total = 0;

        for (int i = 0; i < n; i++) {
            if (maxH < a[i]) {
                continue;
            }
            total += maxH - a[i];
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();

            long a[] = new long[n];
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                min = Math.min(min, a[i]);
            }

            long mn = Arrays.stream(a).min().getAsLong();
            long s = 1;
            long e = mn + x;

            while (s <= e) {
                long mid = s + (e - s) / 2;

                if (calcTotal(mid, a, n) <= x) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

            System.out.println(e);
        }
    }
}
