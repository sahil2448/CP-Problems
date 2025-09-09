
import java.util.*;

public class MakeItAlternating {

    static long MOD = 998244353;

    public static long factorial(int x) {
        // use dynamic programming--->
        long fact[] = new long[x + 1];
        fact[0] = 1;
        for (int i = 1; i <= x; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        return fact[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            char a[] = s.toCharArray();
            int n = s.length();
            long totalOps = 0;
            long shortestSequence = 1;
            long count = 1;
            boolean isAlternative = false;

            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    count++;
                } else {
                    if (count > 1) {
                        isAlternative = true;
                    }
                    shortestSequence = (shortestSequence * (count % MOD)) % MOD;
                    totalOps += (count - 1);
                    count = 1;
                }
            }

            if (count > 1) {
                isAlternative = true;
            }
            shortestSequence = (shortestSequence * (count % MOD)) % MOD;
            totalOps += (count - 1);

            if (!isAlternative) {
                totalOps = 0;
                shortestSequence = 1;
            } else {
                shortestSequence = (shortestSequence * factorial((int) totalOps)) % MOD;
            }

            System.out.println(totalOps + " " + shortestSequence);
        }
    }
}
