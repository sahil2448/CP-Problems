
import java.util.*;

public class BinaryInversions {

    static long countInversions(int[] a) {
        long ans = 0;
        long zerosRight = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 0) {
                zerosRight++;
            } else {
                ans += zerosRight;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long base = countInversions(a);
            long best = base;

            // Flip the first 0 -> 1
            int firstZero = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    firstZero = i;
                    break;
                }
            }
            if (firstZero != -1) {
                a[firstZero] = 1;
                best = Math.max(best, countInversions(a));
                a[firstZero] = 0; // revert
            }

            // Flip the last 1 -> 0
            int lastOne = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] == 1) {
                    lastOne = i;
                    break;
                }
            }
            if (lastOne != -1) {
                a[lastOne] = 0;
                best = Math.max(best, countInversions(a));
                a[lastOne] = 1; // revert
            }

            System.out.println(best);
        }
    }
}
