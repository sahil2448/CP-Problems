
import java.util.*;

public class Tournament {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n + 1];
            int mx = 0;

            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                mx = Math.max(mx, a[i]);
            }

            if (k > 1 || a[j] == mx) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
