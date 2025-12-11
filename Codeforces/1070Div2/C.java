
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Long> odds = new ArrayList<>();
            List<Long> evens = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                if (x % 2 == 1) {
                    odds.add(x);
                } else {
                    evens.add(x);
                }
            }

            if (odds.isEmpty()) {
                for (int i = 0; i < n; i++) {
                    System.out.print("0 ");
                }
                System.out.println();
                continue;
            }

            Collections.sort(odds);
            Collections.sort(evens, Collections.reverseOrder());

            int oCount = odds.size();
            int eCount = evens.size();

            long[] prefEvens = new long[eCount + 1];
            for (int i = 1; i <= eCount; i++) {
                prefEvens[i] = prefEvens[i - 1] + evens.get(i - 1);
            }

            long maxodds = odds.get(oCount - 1);

            for (int k = 1; k <= n; k++) {

                int numerator = k - eCount + 1;
                int tLow;
                if (numerator <= 0) {
                    tLow = 1;
                } else {
                    tLow = (numerator + 1) / 2;
                }

                int oddsToGet = 2 * tLow - 1;

                if (oddsToGet > Math.min(oCount, k)) {
                    System.out.print("0 ");
                } else {
                    int evensToTake = k - oddsToGet;
                    long sum = maxodds;
                    if (evensToTake > 0) {
                        sum += prefEvens[evensToTake];
                    }
                    System.out.print(sum + " ");
                }
            }
            System.out.println();
        }
    }
}
