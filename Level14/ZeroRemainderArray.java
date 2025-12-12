
import java.util.*;

public class ZeroRemainderArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            HashMap<Long, Long> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long rem = a[i] % k;
                if (rem != 0) {
                    long need = k - rem;
                    map.put(need, map.getOrDefault(need, 0L) + 1);
                }
            }

            if (map.isEmpty()) {
                System.out.println(0);
                continue;
            }

            long best = 0;
            for (Map.Entry<Long, Long> e : map.entrySet()) {
                long need = e.getKey();
                long cnt = e.getValue();
                long val = need + (cnt - 1) * k;
                if (val > best) {
                    best = val;
                }
            }

            System.out.println(best + 1);
        }

    }
}
