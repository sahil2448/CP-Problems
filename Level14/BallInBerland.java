
import java.util.*;

public class BallInBerland {

    public static long C2(long n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            int x[] = new int[k];
            int y[] = new int[k];

            for (int i = 0; i < k; i++) {
                x[i] = sc.nextInt();
            }

            for (int i = 0; i < k; i++) {
                y[i] = sc.nextInt();
            }

            if (k == 1) {
                System.out.println("0");
                continue;
            }

            Map<Integer, Integer> hm1 = new HashMap<>();
            Map<Integer, Integer> hm2 = new HashMap<>();

            for (int i = 0; i < k; i++) {
                hm1.put(x[i], hm1.getOrDefault(x[i], 0) + 1);
                hm2.put(y[i], hm2.getOrDefault(y[i], 0) + 1);
            }

            long totalPairs = C2(k);

            for (int val : hm1.values()) {
                if (val > 1) {
                    totalPairs -= C2(val);
                }
            }

            for (int val : hm2.values()) {
                if (val > 1) {
                    totalPairs -= C2(val);
                }
            }

            Map<Long, Integer> cellCount = new HashMap<>();
            for (int i = 0; i < k; i++) {
                long key = ((long) x[i] << 32) ^ (y[i] & 0xffffffffL);
                cellCount.put(key, cellCount.getOrDefault(key, 0) + 1);
            }
            for (int val : cellCount.values()) {
                if (val > 1) {
                    totalPairs += C2(val);
                }
            }

            System.out.println(totalPairs);
        }
    }
}
