
import java.util.*;

public class RakhshRevival {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int[] ps = new int[n + 2];
            int ans = 0, cnt = 0, sum = 0;
            Arrays.fill(ps, 0);

            for (int i = 0; i < n; i++) {
                sum += ps[i];
                if (sum > 0 || s.charAt(i) == '1') {
                    cnt = 0;
                } else {
                    cnt++;
                    if (cnt == m) {
                        sum++;
                        ans++;
                        cnt = 0;
                        if (i + k < n) {
                            ps[i + k]--;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
