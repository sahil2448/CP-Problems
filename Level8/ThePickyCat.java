
import java.util.*;

public class ThePickyCat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            List<int[]> pairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                pairs.add(new int[]{Math.abs(a[i]), i});
            }

            pairs.sort((p1, p2) -> Integer.compare(p1[0], p2[0]));
            int[] ans = new int[n];

            for (int i = 0; i <= n / 2; i++) {
                int index = pairs.get(i)[1];
                ans[index] = 1;
            }

            if (ans[0] == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
