
import java.util.*;

public class PermutationSwap {

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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

            long maxK = Math.abs(arr[0] - 1);

            for (int i = 1; i < n; i++) {
                maxK = gcd(maxK, Math.abs(arr[i] - (i + 1)));
            }

            System.out.println(maxK);
        }
    }
}
