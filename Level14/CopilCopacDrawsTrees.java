
import java.util.*;

public class CopilCopacDrawsTrees {

    // pack two ints into a long (u,v) -> unique key
    static long key(int u, int v) {
        return (((long) u) << 32) | (v & 0xffffffffL);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer>[] adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }

            Map<Long, Integer> order = new HashMap<>(2 * n);
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
                // store the input order for the edge (u,v) and (v,u)
                order.put(key(u, v), i);
                order.put(key(v, u), i);
            }

            int[] dp = new int[n]; // dp[v] = number of readings needed to reach v
            dp[0] = 1;
            int best = 1;

            // iterative DFS stack: pair (node, parent)
            Deque<int[]> stack = new ArrayDeque<>();
            stack.push(new int[]{0, -1});

            while (!stack.isEmpty()) {
                int[] cur = stack.pop();
                int v = cur[0], p = cur[1];
                int prevIdx = (p == -1) ? -1 : order.get(key(p, v));

                for (int to : adj[v]) {
                    if (to == p) {
                        continue;
                    }
                    int curIdx = order.get(key(v, to));
                    // if curIdx < prevIdx then we need a new reading
                    dp[to] = dp[v] + (curIdx < prevIdx ? 1 : 0);
                    if (dp[to] > best) {
                        best = dp[to];
                    }
                    stack.push(new int[]{to, v});
                }
            }

            sb.append(best).append('\n');
        }

        System.out.print(sb.toString());
    }
}
