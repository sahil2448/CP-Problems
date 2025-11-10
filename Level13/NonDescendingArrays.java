
import java.util.*;

public class NonDescendingArrays {

    static int mod = 998244353;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            long ans = 2;

            for (int i = 1; i < n; i++) {
                if (Math.max(a[i - 1], b[i - 1]) <= Math.min(a[i], b[i])) {
                    ans *= 2;
                    ans = ans % 998244353;
                }
            }

            System.out.println(ans);
        }
    }
}
