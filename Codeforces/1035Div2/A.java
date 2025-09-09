
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();

            if (a == b) {
                sb.append(0);
            } else if (a > b) {
                if (a - b == 1 && (a % 2 == 1)) {
                    sb.append(y);
                } else {
                    sb.append(-1);
                }
            } else {
                int d = b - a;
                long[] f0 = new long[d + 1];
                long[] f1 = new long[d + 1];
                long minAddOrXor = Math.min(x, y);

                f0[0] = 0;
                f1[0] = 0;
                for (int k = 1; k <= d; k++) {
                    f1[k] = x + f0[k - 1];
                    f0[k] = minAddOrXor + f1[k - 1];
                }

                long ans = (a % 2 == 0) ? f0[d] : f1[d];
                sb.append(ans);
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }
}
