
import java.util.*;

public class MArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            HashMap<Integer, Integer> cnt = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int remainder = x % m;
                cnt.put(remainder, cnt.getOrDefault(remainder, 0) + 1);
            }

            int ans = 0;

            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int remainder = entry.getKey();
                int frequency = entry.getValue();

                if (remainder == 0) {
                    ans++;
                } else if (2 * remainder == m) {
                    ans++;
                } else if (2 * remainder < m || !cnt.containsKey(m - remainder)) {
                    int x = frequency;
                    int y = cnt.getOrDefault(m - remainder, 0);
                    ans += 1 + Math.max(0, Math.abs(x - y) - 1);
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
