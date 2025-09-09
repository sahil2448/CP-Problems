
import java.util.*;

public class DivideAndEqualize {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        final int MAXP = 100000;
        ArrayList<Integer> primes = sievePrimes(MAXP);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }

            HashMap<Integer, Long> cnt = new HashMap<>();

            for (int value : a) {
                int v = value;
                for (int p : primes) {
                    long pp = 1L * p * p;
                    if (pp > v) {

                        // Why? If p*p > v, then v cannot have any prime factor ≤ p (except possibly v itself). So no further small-prime divisions are possible — any remaining factor must be v (a prime). Breaking avoids useless checks and speeds things up.
                        break;
                    }
                    while (v % p == 0) {
                        cnt.put(p, cnt.getOrDefault(p, 0L) + 1L);
                        v /= p;
                    }
                }
                if (v > 1) {
                    cnt.put(v, cnt.getOrDefault(v, 0L) + 1L);
                }
            }

            boolean ok = true;
            for (long totalExp : cnt.values()) {
                if (totalExp % n != 0) {
                    ok = false;
                    break;
                }
            }
            out.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(out.toString());
    }

    private static ArrayList<Integer> sievePrimes(int limit) {
        boolean[] isComposite = new boolean[limit + 1];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; ++i) {
            if (!isComposite[i]) {
                primes.add(i);
                if ((long) i * i <= limit) {
                    for (int j = i * i; j <= limit; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        return primes;
    }
}
