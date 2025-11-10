
import java.util.*;

public class C {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] top = new int[n + 1];
            int[] bot = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                top[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                bot[i] = sc.nextInt();
            }

            int maxVal = 2 * n;
            int[] prefMinTop = new int[n + 1];
            int[] prefMaxTop = new int[n + 1];
            int[] suffMinBot = new int[n + 2];
            int[] suffMaxBot = new int[n + 2];

            prefMinTop[1] = top[1];
            prefMaxTop[1] = top[1];
            for (int i = 2; i <= n; i++) {
                prefMinTop[i] = Math.min(prefMinTop[i - 1], top[i]);
                prefMaxTop[i] = Math.max(prefMaxTop[i - 1], top[i]);
            }
            suffMinBot[n] = bot[n];
            suffMaxBot[n] = bot[n];
            for (int i = n - 1; i >= 1; i--) {
                suffMinBot[i] = Math.min(suffMinBot[i + 1], bot[i]);
                suffMaxBot[i] = Math.max(suffMaxBot[i + 1], bot[i]);
            }

            int[] minC = new int[n + 1];
            int[] maxC = new int[n + 1];
            for (int c = 1; c <= n; c++) {
                int mn = prefMinTop[c];
                int mx = prefMaxTop[c];
                mn = Math.min(mn, suffMinBot[c]);
                mx = Math.max(mx, suffMaxBot[c]);
                minC[c] = mn;
                maxC[c] = mx;
            }

            ArrayList<Integer>[] addAt = new ArrayList[maxVal + 2];
            for (int i = 0; i <= maxVal + 1; i++) {
                addAt[i] = new ArrayList<>();
            }
            for (int c = 1; c <= n; c++) {
                int mn = minC[c];
                int mx = maxC[c];
                addAt[mn].add(mx);
            }

            long ans = 0L;
            int curMinMax = Integer.MAX_VALUE;
            for (int l = maxVal; l >= 1; l--) {
                for (int val : addAt[l]) {
                    if (val < curMinMax) {
                        curMinMax = val;
                    }
                }
                if (curMinMax == Integer.MAX_VALUE) {
                    continue;
                }
                int rlow = Math.max(l, curMinMax);
                if (rlow <= maxVal) {
                    ans += (maxVal - rlow + 1);
                }
            }

            System.out.println(ans);
        }
    }
}
