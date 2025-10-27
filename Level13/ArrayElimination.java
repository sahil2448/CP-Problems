
import java.util.*;

public class ArrayElimination {

    public static long gcd(long a, long b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            Map<Long, Long> hm = new HashMap<>();
            for (long i = 0; i < n; i++) {
                long curr = sc.nextLong();
                for (int j = 0; j <= 30; j++) {
                    if ((curr & (1 << j)) != 0) {
                        hm.put((long) j, hm.getOrDefault((long) j, 0L) + 1L);
                    }
                }
            }

            ArrayList<Long> list = new ArrayList<>();
            long gcd = 0;

            if (hm.isEmpty()) {
                for (long i = 0; i < n; i++) {
                    System.out.print(i + 1 + " ");
                }
            }

            // traversing the hashmap
            for (Map.Entry<Long, Long> entry : hm.entrySet()) {
                long key = entry.getKey();
                long value = entry.getValue();

                if (gcd == 0) {
                    gcd = value;
                } else {
                    gcd = gcd(gcd, value);
                }
            }

            for (long i = 1; i * i <= gcd; i++) {
                if (gcd % i == 0) {
                    list.add(i);
                    if (i != gcd / i) {
                        list.add(gcd / i);
                    }
                }
            }

            Collections.sort(list);

            for (long i : list) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
    }
}
