
import java.util.*;

public class NoCasinoInMountains {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            int ans = 0;
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (a[i] == 1) {
                    ans += (cnt + 1) / (k + 1);
                    cnt = 0;
                    continue;
                } else {
                    cnt++;
                }
            }
            ans += (cnt + 1) / (k + 1);

            System.out.println(ans);

        }
    }
}
