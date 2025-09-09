
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long px = sc.nextLong();
            long py = sc.nextLong();
            long qx = sc.nextLong();
            long qy = sc.nextLong();

            long[] a = new long[n];
            long S = 0, M = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                S += a[i];
                if (a[i] > M) {
                    M = a[i];
                }
            }

            long dx = px - qx;
            long dy = py - qy;
            long D2 = dx * dx + dy * dy;

            long R = S - M;
            long lo = (M > R ? M - R : 0);
            long hi = S;

            long lo2 = lo * lo;
            long hi2 = hi * hi;

            if (D2 >= lo2 && D2 <= hi2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
