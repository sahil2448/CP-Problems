
import java.util.*;

public class C {

    // Function to count number of 1-bits
    static int beauty(long x) {
        int cnt = 0;
        while (x > 0) {
            cnt += (x & 1);
            x >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n];
            int[] initialBeauty = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                initialBeauty[i] = beauty(a[i]);
            }

            List<long[]> ops = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int bit = 0; bit < 61; bit++) {
                    if ((a[i] & (1L << bit)) == 0) {
                        long target = (a[i] | (1L << bit));
                        long cost = target - a[i];
                        ops.add(new long[]{cost, i, bit});
                    }
                }
            }
            ops.sort(Comparator.comparingLong(x -> x[0]));

            for (long[] op : ops) {
                long cost = op[0];
                int i = (int) op[1];
                int bit = (int) op[2];
                if (cost <= k) {
                    k -= cost;
                    a[i] |= (1L << bit);
                }
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += beauty(a[i]);
            }
            System.out.println(sum);
        }
    }
}
