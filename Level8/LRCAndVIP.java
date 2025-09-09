
import java.util.*;

public class LRCAndVIP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                mn = Math.min(mn, a[i]);
                mx = Math.max(mx, a[i]);
            }
            if (mn == mx) {
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
            for (int i = 0; i < n; i++) {
                System.out.print((1 + (a[i] == mx ? 1 : 0)));
                if (i + 1 == n) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
