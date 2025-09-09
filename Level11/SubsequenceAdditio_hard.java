
import java.util.*;

public class SubsequenceAdditio_hard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);

            if (a[0] != 1) {
                System.out.println("NO");
                continue;
            }
            boolean flag = true;
            long sum = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] > sum) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }

                sum += a[i];
            }
            if (flag) {
                System.out.println("YES");

            }
        }
    }
}
