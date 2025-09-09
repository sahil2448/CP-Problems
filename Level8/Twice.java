
import java.util.*;

public class Twice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                hm.put(x, hm.getOrDefault(x, 0) + 1);
            }

            int score = 0;

            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                int val = entry.getValue();
                score += val / 2;
            }

            System.out.println(score);

        }
    }
}
