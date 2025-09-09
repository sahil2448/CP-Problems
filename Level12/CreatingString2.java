
import java.util.Scanner;

public class CreatingString2 {

    static final int MOD = 1_000_000_007;
    static final int MAX = 1_000_001;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    static long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    // Fast exponentiation
    static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        precompute();

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        long result = fact[s.length()];
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                result = (result * invFact[count[i]]) % MOD;
            }
        }
        System.out.println(result);
    }
}
