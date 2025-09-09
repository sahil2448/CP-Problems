
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            Arrays.sort(x);
            if ((x[0] & 1) == (x[n - 1] & 1)) {
                System.out.println(0);
                continue;
            }
            int left = n;
            for (int i = 1; i < n; i++) {
                if ((x[i] & 1) != (x[0] & 1)) {
                    left = i;
                    break;
                }
            }
            int right = n;
            for (int i = 1; i < n; i++) {
                if ((x[n - i - 1] & 1) != (x[n - 1] & 1)) {
                    right = i;
                    break;
                }
            }
            System.out.println(Math.min(left, right));
        }
        sc.close();
    }
}
