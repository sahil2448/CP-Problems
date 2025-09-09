
import java.util.*;
import java.io.*;

public class C {

    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static int ask(int x, List<Integer> s) {
        out.print("? " + x + " " + s.size());
        for (int val : s) {
            out.print(" " + val);
        }
        out.println();
        out.flush();
        return in.nextInt();
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] d = new int[n + 1];
            List<Integer> allNodes = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                allNodes.add(i);
            }
            for (int i = 1; i <= n; i++) {
                d[i] = ask(i, allNodes);
            }

            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i + 1;
            }
            Arrays.sort(indices, (a, b) -> d[b] - d[a]);

            List<Integer> path = new ArrayList<>();
            path.add(indices[0]);

            for (int i = 1; i < n; i++) {
                int node = indices[i];
                List<Integer> querySet = new ArrayList<>(path);
                querySet.add(node);
                int lastNode = path.get(path.size() - 1);
                int response = ask(lastNode, querySet);
                if (response > 1) {
                    path.add(node);
                }
            }

            out.print("! " + path.size());
            for (int node : path) {
                out.print(" " + node);
            }
            out.println();
            out.flush();
        }
    }
}
