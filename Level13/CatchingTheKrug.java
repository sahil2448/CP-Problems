
import java.util.*;

public class CatchingTheKrug {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long rk = sc.nextLong();
            long ck = sc.nextLong();
            long rd = sc.nextLong();
            long cd = sc.nextLong();
            long ans = 0;
            if (rd > rk) {
                ans = Math.max(ans, rd);
            } else if (rd < rk) {
                ans = Math.max(ans, n - rd);
            }
            if (cd > ck) {
                ans = Math.max(ans, cd);
            } else if (cd < ck) {
                ans = Math.max(ans, n - cd);
            }

            System.out.println(ans);
        }
    }

}
