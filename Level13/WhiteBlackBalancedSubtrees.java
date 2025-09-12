
import java.util.*;

public class WhiteBlackBalancedSubtrees {

    static ArrayList<Long> childrens[];
    static String s;
    static long ans;

    public static long dfs(long p) {
        long curr = s.charAt((int) p - 1) == 'W' ? 1 : -1;

        for (long child : childrens[(int) p]) {
            curr += dfs(child);
        }

        if (curr == 0) {
            ans++;
        }

        return curr;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            childrens = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                childrens[i] = new ArrayList<>();
            }
            for (int i = 2; i <= n; i++) {
                long p = sc.nextLong();
                childrens[(int) p].add((long) i);
            }

            s = sc.next();
            ans = 0;
            dfs(1);
            System.out.println(ans);

        }
    }
}
