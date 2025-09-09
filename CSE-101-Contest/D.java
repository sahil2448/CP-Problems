// NAME : SAHIL YUVRAJ KAMBLE
// ENROLLMENT NO. : 23112087

import java.util.*;
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt(), q = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            Arrays.sort(a);

            long[] pref = new long[n];

            for (int i = 0; i < n; i++) {
                pref[i] = a[n - 1 - i] + (i > 0 ? pref[i - 1] : 0);
            }

            while (q-- > 0) {
                long x = sc.nextLong();
                int l = 0, r = n;

                while (l < r) {
                    int m = (l + r) >>> 1;
                    if (pref[m] >= x) r = m;
                    else l = m + 1;
                }
                
                System.out.println(l == n ? -1 : l + 1);
            }
        }
        sc.close();
    }
}
