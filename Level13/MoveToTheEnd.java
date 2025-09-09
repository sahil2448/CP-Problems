
import java.util.*;

public class MoveToTheEnd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long preMax[] = new long[n];
            preMax[0] = a[0];
            long mx = a[0];
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx, a[i]);
                preMax[i] = mx;
            }

            long psum[] = new long[n + 1];
            for (int i = 0; i < n; i++) {
                psum[i + 1] = psum[i] + a[i];
            }
            long total = psum[n];

            long ans[] = new long[n];
            long sum = 0;

            for (int i = n - 1; i >= 0; i--) {
                sum = preMax[i] + (total - psum[i + 1]);
                ans[n - 1 - i] = sum;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + (i + 1 == n ? "" : " "));
            }
            System.out.println();
        }
    }
}
