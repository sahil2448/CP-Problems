
import java.util.*;

public class And0SumBit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        long MOD = (long) 1e9 + 7;
        while (t-- > 0) {
            long n = sc.nextLong();

            long k = sc.nextLong();

            long ans = 1;

            for (int i = 0; i < k; i++) {
                ans = (ans * n) % MOD;
            }

            System.out.println(ans % MOD);
        }
    }
}
