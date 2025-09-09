
import java.util.*;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            ArrayList<Integer>[] pos = new ArrayList[n + 1];
            for (int v = 0; v <= n; v++) {
                pos[v] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                pos[b[i]].add(i);
            }

            int[] a = new int[n];
            int curLabel = 1;
            boolean ok = true;

            for (int v = 1; v <= n; v++) {
                int cnt = pos[v].size();
                if (cnt == 0) {
                    continue;
                }
                if (cnt % v != 0) {
                    ok = false;
                    break;
                }
                for (int i = 0; i < cnt; i += v) {
                    for (int j = 0; j < v; j++) {
                        int idx = pos[v].get(i + j);
                        a[idx] = curLabel;
                    }
                    curLabel++;
                }
            }

            if (!ok) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(a[i]);
                    if (i + 1 < n) {
                        sb.append(' ');
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}
