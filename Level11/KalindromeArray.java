
import java.util.*;

public class KalindromeArray {

    private static boolean check(int[] a, int n, int x) {
        int[] tmp = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] != x) {
                tmp[m++] = a[i];
            }
        }

        for (int i = 0; i < m; i++) {
            if (tmp[i] != tmp[m - 1 - i]) {
                return false;
            }
        }
        return true;
    }

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

            boolean ok = true;

            for (int i = 0; i < n; i++) {
                if (a[i] != a[n - 1 - i]) {
                    ok = check(a, n, a[i]) || check(a, n, a[n - 1 - i]);
                    break;
                }
            }
            out.append(ok ? "YES" : "NO").append('\n');
        }
        System.out.print(out.toString());
    }
}
