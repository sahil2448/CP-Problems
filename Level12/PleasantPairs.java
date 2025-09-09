
import java.util.*;

public class PleasantPairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[][] v = new long[n][2];
            for (int i = 0; i < n; i++) {
                v[i][0] = sc.nextLong();
                v[i][1] = i + 1;
            }

            Arrays.sort(v, Comparator.comparingLong(a -> a[0]));

            int ans = 0;
            for (int i = 0; i < n; i++) {
                long ai = v[i][0];
                for (int j = i + 1; j < n; j++) {
                    long aj = v[j][0];
                    long prod = ai * aj;
                    if (prod >= 2L * n) {
                        break;
                    }
                    if (prod == v[i][1] + v[j][1]) {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
