
import java.util.*;

public class SameDifferences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int diff[] = new int[n];
            for (int i = 0; i < n; i++) {
                diff[i] = a[i] - i;
            }

            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                hm.put(diff[i], hm.getOrDefault(diff[i], 0) + 1);
            }

            long ans = 0L;
            for (int freq : hm.values()) {
                ans += (long) freq * (freq - 1) / 2;
            }

            System.out.println(ans);

        }
    }
}
