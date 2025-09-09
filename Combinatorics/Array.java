
import java.util.*;

public class Array {

    static final long MOD = 1_000_000_007L;

    static long modPow(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = 2 * n;
        long[] fact = new long[max + 1];
        long[] invFact = new long[max + 1];

        fact[0] = 1;
        for (int i = 1; i <= max; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[max] = modPow(fact[max], MOD - 2);
        for (int i = max - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        long comb = fact[2 * n - 1];
        comb = comb * invFact[n] % MOD;
        comb = comb * invFact[n - 1] % MOD;

        long ans = (2 * comb) % MOD;
        ans = (ans - n) % MOD;
        if (ans < 0) {
            ans += MOD;
        }
        System.out.println(ans);
    }
}
