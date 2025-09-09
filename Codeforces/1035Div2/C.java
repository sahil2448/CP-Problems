
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long k = sc.nextLong();

            if ((n & 1) == 1) {
                System.out.println(l);
                continue;
            }

            long half = n >>> 1;
            if ((half & 1) == 1) {
                System.out.println(-1);
                continue;
            }

            long bestX = Long.MAX_VALUE;

            for (int u = 0; u < 63; u++) {
                long bit = 1L << u;
                if ((l & bit) != 0) {
                    continue;
                }
                long prefix = l >>> (u + 1);
                long candidate = (prefix << (u + 1)) | bit;
                long x = candidate & ~l;
                if (x > l && x <= r) {
                    if (x < bestX) {
                        bestX = x;
                    }
                }
            }

            if (bestX == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(k <= half ? l : bestX);
            }
        }
    }
}
