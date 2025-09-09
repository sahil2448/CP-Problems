
import java.util.*;

public class Clockwork {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int thLeft = 2 * i + 1;
                int thRight = 2 * (n - 1 - i) + 1;
                int mx = Math.max(thLeft, thRight);

                if (a[i] < mx) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
