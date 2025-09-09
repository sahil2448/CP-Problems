
import java.util.HashMap;
import java.util.Scanner;

public class ArrayCloningTechnique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextInt();
            long arr[] = new long[(int) n];
            HashMap<Long, Long> hm = new HashMap<>();

            for (long i = 0; i < n; i++) {
                arr[(int) i] = sc.nextLong();
            }

            for (long i = 0; i < n; i++) {
                hm.put(arr[(int) i], hm.getOrDefault(arr[(int) i], (long) 0) + 1);
            }

            long maxFreq = 0;
            for (long freq : hm.values()) {
                maxFreq = Math.max(maxFreq, freq);
            }

            long ops = 0;
            while (maxFreq < n) {
                ops++;
                if (maxFreq * 2 <= n) {
                    ops += maxFreq;
                    maxFreq *= 2;
                } else {
                    ops += n - maxFreq;
                    maxFreq = n;
                }
            }

            System.out.println(ops);
        }
    }
}
