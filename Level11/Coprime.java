
import java.util.*;

public class Coprime {

    static final int MAX = 1000;
    static List<Integer>[] pairs = new ArrayList[MAX + 1];

    public static void main(String[] args) {
        for (int i = 1; i <= MAX; i++) {
            pairs[i] = new ArrayList<>();
        }
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                if (gcd(i, j) == 1) {
                    pairs[i].add(j);
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] idx = new int[MAX + 1];
            for (int i = 1; i <= n; i++) {
                int x = sc.nextInt();
                idx[x] = i;
            }

            int ans = -1;
            for (int i = 1; i <= MAX; i++) {
                if (idx[i] == 0) {
                    continue;
                }
                for (int j : pairs[i]) {
                    if (idx[j] != 0) {
                        ans = Math.max(ans, idx[i] + idx[j]);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }
}
