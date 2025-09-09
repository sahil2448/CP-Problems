
import java.util.*;

public class DormysPains {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Long, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                hm.put(x, hm.getOrDefault(x, 0) + 1);
            }

            if (hm.size() > 2) {
                System.out.println("NO");
            } else if (hm.size() == 1) {
                System.out.println("YES");
            } else {
                List<Integer> freq = new ArrayList<>(hm.values());
                if (Math.abs(freq.get(0) - freq.get(1)) <= 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
