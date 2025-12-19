
import java.util.*;

public class BasketballExercise {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        long b[] = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }

        long dp1[] = new long[n];
        long dp2[] = new long[n];

        dp1[0] = a[0];
        dp2[0] = b[0];

        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp2[i - 1] + a[i], dp1[i - 1]);
            dp2[i] = Math.max(dp1[i - 1] + b[i], dp2[i - 1]);
        }

        System.out.println(Math.max(dp1[n - 1], dp2[n - 1]));

    }
}
