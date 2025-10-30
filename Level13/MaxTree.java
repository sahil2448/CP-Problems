
import java.io.*;
import java.util.*;

public class MaxTree {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] inDegree = new int[n + 1];
            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                String[] input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                long x = Long.parseLong(input[2]);
                long y = Long.parseLong(input[3]);

                if (x > y) {
                    graph[u].add(v);
                    inDegree[v]++;
                } else {
                    graph[v].add(u);
                    inDegree[u]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }

            int[] ans = new int[n + 1];
            int ct = n;

            while (!q.isEmpty()) {
                int curr = q.poll();
                ans[curr] = ct;
                ct--;

                for (int nbr : graph[curr]) {
                    inDegree[nbr]--;
                    if (inDegree[nbr] == 0) {
                        q.add(nbr);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                pw.print(ans[i] + " ");
            }
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}
