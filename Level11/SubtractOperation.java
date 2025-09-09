
import java.util.*;

public class SubtractOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);                // O(n log n)
            boolean ok = hasDifferenceK(a, k);   // O(n)

            out.append(ok ? "YES\n" : "NO\n");
        }
        System.out.print(out.toString());

    }

    private static boolean hasDifferenceK(long[] a, long k) {
        int i = 0, j = 1, n = a.length;
        while (j < n) {
            long diff = a[j] - a[i];
            if (diff == k) {
                return true;
            }
            if (diff < k) {
                ++j;
            } else {
                ++i;
                if (i == j) {
                    ++j;

                }
            }
        }
        return false;
    }
}
