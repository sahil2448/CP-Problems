
import java.util.*;

public class HamiiidHaaamidHamid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            String s = sc.next();

            if (x == 1 || x == n) {
                System.out.println("1");
                continue;
            }

            x--;
            int inf = Integer.MAX_VALUE;
            int lf = -inf, rg = inf;

            for (int i = x - 1; i >= 0; i--) {
                if (s.charAt(i) == '#') {
                    lf = i;
                    break;
                }
            }

            for (int i = x + 1; i < n; i++) {
                if (s.charAt(i) == '#') {
                    rg = i;
                    break;
                }
            }

            if (lf == -inf && rg == inf) {
                System.out.println("1");
                continue;
            }

            System.out.println(Math.max(Math.min(x + 1, n - rg + 1), Math.min(lf + 2, n - x)));
        }

    }
}
