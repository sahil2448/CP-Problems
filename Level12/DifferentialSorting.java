
import java.util.*;

public class DifferentialSorting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            boolean isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    isSorted = false;
                    break;
                }

            }

            if (isSorted) {
                System.out.println(0);
                continue;
            }

            if (a[n - 2] > a[n - 1]) {
                System.out.println(-1);
                continue;
            }

            if (a[n - 1] >= 0) {
                System.out.println(n - 2);

                for (int i = 0; i < n - 2; i++) {
                    System.out.println(i + 1 + " " + (n - 1) + " " + (n));
                }
            } else {
                System.out.println(-1);
            }
        }

    }
}
