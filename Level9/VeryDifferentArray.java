
import java.util.*;

public class VeryDifferentArray {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            for (int i = 0, j = m - 1; i < j; i++, j--) {
                int tmp = b[i];
                b[i] = b[j];
                b[j] = tmp;
            }

            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = b[m - n + i];
            }

            long s = 0;
            for (int i = 0; i < n; i++) {
                s += Math.abs(c[i] - a[i]);
            }
            long res = 0;
            for (int k = 0; k <= n; k++) {
                res = Math.max(res, s);
                if (k < n) {
                    s -= Math.abs(c[k] - a[k]);
                    c[k] = b[k];
                    s += Math.abs(c[k] - a[k]);
                }
            }
            System.out.println(res);
        }
    }

}
