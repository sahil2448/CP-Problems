
import java.util.*;

public class BuyingShovels {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            long n = sc.nextLong();
            long k = sc.nextLong();
            long ans = n;

            for (int j = 1; j * j <= n; j++) {
                if (n % j == 0) {
                    if (j <= k) {
                        ans = Math.min(ans, n / j);
                    }
                    if ((n / j) <= k) {
                        ans = Math.min(ans, j);
                    }
                }
            }

            System.out.println(ans);
        }

    }
}
