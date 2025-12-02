
import java.util.*;

public class HassamAndFriends {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        for (int _tc = 0; _tc < t; _tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] nearestEnemy = new int[n + 1];

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a > b) {// swap
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                // for subsegments ending at b, the start must be strictly after any conflicting a
                if (a > nearestEnemy[b]) {
                    nearestEnemy[b] = a;
                }
            }

            int[] maxLeft = new int[n + 1];

            maxLeft[1] = 1;
            long ans = 1;

            for (int i = 2; i <= n; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], nearestEnemy[i] + 1);
                ans += i - maxLeft[i] + 1;
            }

            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}

/*
Time Complexity (TC): O(n + m)
Space Complexity (SC): O(n)
 */
