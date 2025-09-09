
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            ArrayList<Integer>[] posLists = new ArrayList[n + 1];
            for (int v = 1; v <= n; v++) {
                posLists[v] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                posLists[a[i]].add(i + 1);
            }

            long ans = Long.MAX_VALUE;
            for (int v = 1; v <= n; v++) {
                List<Integer> list = posLists[v];
                if (list.isEmpty()) {
                    continue;
                }

                int runStart = list.get(0);
                int prevIdx = runStart;

                for (int k = 1; k < list.size(); k++) {
                    int curIdx = list.get(k);
                    if (curIdx == prevIdx + 1) {
                        prevIdx = curIdx;
                    } else {
                        long cost = ((long) (runStart - 1) + (long) (n - prevIdx)) * v;
                        if (cost < ans) {
                            ans = cost;
                        }
                        runStart = curIdx;
                        prevIdx = curIdx;
                    }
                }

                {
                    long cost = ((long) (runStart - 1) + (long) (n - prevIdx)) * v;
                    if (cost < ans) {
                        ans = cost;
                    }
                }
            }

            System.out.println(ans);
        }

    }
}
