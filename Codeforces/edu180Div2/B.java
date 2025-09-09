
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int ans = -1;

            for (int i = 2; i < n; i++) {
                int lo = Math.min(a[i - 1], a[i - 2]);
                int hi = Math.max(a[i - 1], a[i - 2]);
                if (lo <= a[i] && a[i] <= hi) {
                    ans = 1;
                }
            }

            for (int i = 0; i < n - 2; i++) {
                int lo = Math.min(a[i + 1], a[i + 2]);
                int hi = Math.max(a[i + 1], a[i + 2]);
                if (lo <= a[i] && a[i] <= hi) {
                    ans = 1;
                }
            }

            for (int i = 1; i < n; i++) {
                if (Math.abs(a[i] - a[i - 1]) <= 1) {
                    ans = 0;
                }
            }

            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}
