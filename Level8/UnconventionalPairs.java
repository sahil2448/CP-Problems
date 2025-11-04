
import java.util.*;

public class UnconventionalPairs {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            int diff = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i += 2) {
                diff = Math.max(diff, a[i + 1] - a[i]);
            }

            System.out.println(diff);
        }
    }
}
