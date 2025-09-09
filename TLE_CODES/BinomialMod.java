
public class BinomialMod {

    static final int N = 1_000_000;       // <-- set this to your max n
    static final int P = 1_000_000_007;   // <-- your modulus (prime)
    static long[] fact = new long[N + 1];
    static long[] invFact = new long[N + 1];

    public static void main(String[] args) {
        precompute();
        // example:
        System.out.println(nCr(10, 3));  // 120
    }

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % P;
        }

        invFact[N] = modPow(fact[N], P - 2);
        for (int i = N; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % P;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        return fact[n] * invFact[r] % P * invFact[n - r] % P;
    }

    static long nPr(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        return fact[n] * invFact[n - r] % P;
    }

    static long modPow(long a, long e) { // using binary exponentiation
        long res = 1;
        while (e > 0) {
            if (e % 2 == 1) {
                res = res * a % P;
            }
            a = a * a % P;
            e = e / 2;
        }
        return res;
    }
}
