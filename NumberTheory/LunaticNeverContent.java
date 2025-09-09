
import java.util.*;

public class LunaticNeverContent {

    public static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
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

            long ans = 0;
            for (long i = 0; i < n; i++) {
                ans = GCD(ans, Math.abs(arr[(int) i] - arr[(int) n - (int) i - 1]));
            }

            System.out.println(ans);

        }
    }
}
