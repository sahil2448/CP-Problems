
import java.util.*;

public class Desorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            boolean isSorted = true;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (!isSorted) {
                System.out.println(0);
                continue;
            }

            long ans = Long.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                long operations = (a[i + 1] - a[i]) / 2 + 1;
                ans = Math.min(ans, operations);
            }
            System.out.println(ans);
        }
    }
}
