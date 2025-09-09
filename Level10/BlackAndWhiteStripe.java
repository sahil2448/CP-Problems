
import java.util.*;

public class BlackAndWhiteStripe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String s = sc.next();

            int prefixArr[] = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefixArr[i + 1] = prefixArr[i] + (s.charAt(i) == 'W' ? 1 : 0);
            }
            int min_cells = Integer.MAX_VALUE;
            for (int i = 0; i <= n - k; i++) {
                int diff = prefixArr[i + k] - prefixArr[i];
                min_cells = Math.min(min_cells, diff);
            }

            System.out.println(min_cells);
        }
    }
}
