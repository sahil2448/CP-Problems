
import java.util.*;

public class CandyBox_Easy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }

            List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());

            long ans = 0;
            int prev = Integer.MAX_VALUE;
            for (Map.Entry<Long, Integer> entry : list) {
                int freq = entry.getValue();
                int take = Math.min(freq, prev - 1);
                if (take <= 0) {
                    break;
                }
                ans += take;
                prev = take;
            }

            System.out.println(ans);

        }
    }
}
