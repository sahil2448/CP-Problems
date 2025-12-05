
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }

            long maxK = 0;
            long minK = 0;

            for (int i = 0; i < n; i++) {

                long redMax = maxK - a[i];
                long redMin = minK - a[i];

                long blueMax = b[i] - minK;
                long blueMin = b[i] - maxK;
                maxK = Math.max(redMax, blueMax);
                minK = Math.min(redMin, blueMin);
            }

            System.out.println(maxK);
        }
    }
}
