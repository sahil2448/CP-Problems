
import java.util.*;

public class GCDPartition {

    public static long gcdFunc(long a, long b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcdFunc(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            long prefixArr[] = new long[(int) n];
            prefixArr[0] = arr[0];
            for (int i = 1; i < n; i++) {
                prefixArr[i] = prefixArr[i - 1] + arr[i];
            }

            long max = 1;

            for (int i = 0; i < n - 1; i++) {
                long sum1 = prefixArr[i];
                long sum2 = prefixArr[(int) n - 1] - prefixArr[i];

                long gcd = gcdFunc(sum1, sum2);
                max = Math.max(gcd, max);

            }

            System.out.println(max);
        }
    }
}
