
import java.util.*;

public class MaximalAND {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            int bits[] = new int[32];
            long a[] = new long[(int) n];
            long ans = (long) Math.pow(2, 32) - 1;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                ans &= a[i];
                for (int j = 0; j < 32; j++) {
                    if ((a[i] & (1L << j)) != 0) {
                        bits[j]++;
                    }
                }
            }

            for (int i = 30; i >= 0; i--) {
                if (k >= n - bits[i]) {
                    ans |= (1L << i);
                    k -= n - bits[i];
                }
            }

            System.out.println(ans);
        }
    }
}
