
import java.util.*;

public class Quests {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            long ans = 0;
            long sum = 0;
            long maxb = 0;
            for (int i = 0; i < Math.min(n, k); i++) {
                sum += a[(int) i];
                maxb = Math.max(maxb, b[(int) i]);

                ans = Math.max(ans, sum + maxb * (k - (i + 1)));
            }

            System.out.println(ans);
        }
    }
}
