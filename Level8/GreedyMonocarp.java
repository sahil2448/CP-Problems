
import java.util.Arrays;
import java.util.Scanner;

public class GreedyMonocarp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                int x = a[i];
                if (sum + x <= k) {
                    sum += x;
                } else {
                    break;
                }
            }
            out.append(k - sum).append('\n');
        }

        System.out.print(out.toString());
    }
}
