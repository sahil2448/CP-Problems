
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
            Collections.sort(list, (a, b) -> a.getValue() - b.getValue());

            int x = 0;
            int sz = list.size();
            int mx = 0;
            for (Map.Entry<Integer, Integer> entry : list) {
                int val = entry.getValue();
                mx = Math.max(mx, val * (sz - x));
                x++;
            }

            System.out.println(mx);

        }
    }

}
