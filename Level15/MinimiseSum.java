
import java.util.*;

public class MinimiseSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            System.out.println(Math.min(2 * a[0], a[0] + a[1]));

        }
    }
}
