
import java.util.*;

public class MonocarpsString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();

            int countA = 0, countB = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'a') {
                    countA++;
                } else if (s.charAt(j) == 'b') {
                    countB++;
                }
            }

            int cur = countA - countB;
            Map<Integer, Integer> hm = new HashMap<>();
            int preSum = 0;
            hm.put(preSum, -1);
            int ans = n;

            for (int j = 0; j < n; j++) {
                preSum += (s.charAt(j) == 'a') ? 1 : -1;
                hm.put(preSum, j);
                if (hm.containsKey(preSum - cur)) {
                    ans = Math.min(ans, j - hm.get(preSum - cur));
                }
            }

            System.out.println(ans == n ? -1 : ans);
        }
    }
}
