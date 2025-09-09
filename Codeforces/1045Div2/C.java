
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] originalArray = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                originalArray[i] = sc.nextLong();
            }

            int oddCount = (n + 1) / 2;
            int evenCount = n / 2;
            long[] odds = new long[oddCount + 1];
            long[] evens = new long[evenCount + 1];

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) {
                    odds[(i + 1) / 2] = originalArray[i];
                } else {
                    evens[i / 2] = originalArray[i];
                }
            }

            long ans = 0;

            for (int i = 1; i < oddCount; i++) {
                long currOdd = odds[i];
                long nextOdd = odds[i + 1];
                long currEven = evens[i];

                if (currOdd + nextOdd > currEven) {
                    long excess = currOdd + nextOdd - currEven;
                    long reduced = Math.min(excess, nextOdd);
                    odds[i + 1] = nextOdd - reduced;
                    ans += reduced;
                    excess -= reduced;
                    if (excess > 0) {
                        odds[i] = currOdd - excess;
                        ans += excess;
                    }
                }
            }

            if (n % 2 == 0) {
                long lastOdd = odds[oddCount];
                long lastEven = evens[evenCount];
                if (lastOdd > lastEven) {
                    ans += lastOdd - lastEven;
                }
            }

            System.out.println(ans);
        }
    }
}
