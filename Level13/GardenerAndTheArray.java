
import java.util.*;

public class GardenerAndTheArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> mp = new HashMap<>();
            List<List<Integer>> v = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < x; j++) {
                    int val = sc.nextInt();
                    temp.add(val);
                    mp.put(val, mp.getOrDefault(val, 0) + 1);
                }
                v.add(temp);
            }

            String ans = "No";
            for (int i = 0; i < n; i++) {
                boolean f = true;
                for (int it : v.get(i)) {
                    if (mp.get(it) == 1) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    ans = "Yes";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
