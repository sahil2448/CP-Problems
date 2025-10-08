
import java.util.*;

public class JustEatIt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long a[] = new long[n];

            long totalYsser = 0;
            long totalNegative = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                totalYsser += a[i];
                if (a[i] < 0) {
                    totalNegative++;
                }
            }

            long totalAdel = 0;

            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum = sum + a[i];
                if (sum < 0) {
                    sum = 0;
                }
                totalAdel = Math.max(totalAdel, sum);
            }

            sum = 0;
            for (int i = 1; i < n; i++) {
                sum = sum + a[i];
                if (sum < 0) {
                    sum = 0;
                }
                totalAdel = Math.max(totalAdel, sum);

            }

            if (totalYsser > totalAdel) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
