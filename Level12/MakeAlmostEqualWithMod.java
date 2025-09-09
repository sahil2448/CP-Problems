
import java.util.*;

public class MakeAlmostEqualWithMod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long ans = 0;
            for (int i = 1; i <= 60; i++) {
                Set<Long> set = new HashSet<>();
                long k = 1L << i;

                for (int j = 0; j < n; j++) {
                    set.add(a[j] % k);
                }

                if (set.size() == 2) {
                    ans = k;
                    break;
                }
            }

            System.out.println(ans);

        }

    }
}
