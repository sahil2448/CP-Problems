
import java.util.*;

public class DejaVu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long x[] = new long[q];
            for (int i = 0; i < q; i++) {
                x[i] = sc.nextLong();
            }

            int prev = 31;
            for (int i = 0; i < q; i++) {
                if (x[i] >= prev) {
                    continue;
                }

                long pow = (long) Math.pow(2, x[i]);

                for (int j = 0; j < n; j++) {
                    if (a[j] % pow == 0) {
                        a[j] += (long) Math.pow(2, x[i] - 1);
                    }
                }

                prev = (int) x[i];
            }

            for (long i = 0; i < n; i++) {
                System.out.print(a[(int) i] + " ");
            }
            System.out.println();
        }
    }
}
