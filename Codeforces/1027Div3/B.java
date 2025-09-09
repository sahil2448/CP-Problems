
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            int m = n / 2;
            boolean cond1 = (zeros - (m - k)) % 2 == 0;
            boolean cond2 = false;
            boolean cond3 = ones >= (m - k);

            if (cond1) {
                int a = (zeros - (m - k)) / 2;
                if (a >= 0 && a <= k) {
                    cond2 = true;
                }
            }

            if (cond1 && cond2 && cond3) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
