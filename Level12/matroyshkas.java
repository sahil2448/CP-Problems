
import java.util.*;

public class matroyshkas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);
            HashMap<Long, Integer> freq = new HashMap<>();
            for (long x : a) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            List<Long> keys = new ArrayList<>(freq.keySet());
            Collections.sort(keys);

            int count = freq.get(keys.get(0));
            for (int i = 1; i < keys.size(); i++) {
                long curr = keys.get(i);
                long prev = keys.get(i - 1);

                if (curr == prev + 1) {
                    int extra = freq.get(curr) - freq.get(prev);
                    if (extra > 0) {
                        count += extra;
                    }
                } else {
                    count += freq.get(curr);
                }
            }

            System.out.println(count);
        }
    }
}
