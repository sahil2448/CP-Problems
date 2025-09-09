
import java.util.*;

public class EatingCandies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int l = 0;
            int r = n - 1;
            long suml = a[l];
            long sumr = a[r];
            int ans = 0;

            while (l < r) {
                if (suml == sumr) {
                    ans = Math.max(ans, (l + 1) + (n - r));
                }

                if (suml <= sumr) {
                    l++;
                    suml += a[l];
                } else {
                    r--;
                    sumr += a[r];
                }
            }

            System.out.println(ans);
        }
    }
}
