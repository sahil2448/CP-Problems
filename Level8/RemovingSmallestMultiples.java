import java.util.*;

public class RemovingSmallestMultiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            boolean[] done = new boolean[n + 1];
            long cost = 0;

            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '1') continue;

                for (int j = i; j <= n; j += i) {
                    if (s.charAt(j - 1) == '1') {
                        break;
                    }
                    if (!done[j]) {
                        done[j] = true;
                        cost += i;
                    }
                }
            }

            System.out.println(cost);
        }

        sc.close();
    }
}
