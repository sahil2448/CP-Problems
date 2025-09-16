
import java.util.*;

public class DeepDownBelow {

    static class Pair implements Comparable<Pair> {

        long val;
        int cnt; 

        Pair(long v, int c) {
            this.val = v;
            this.cnt = c;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.val, o.val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Pair> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                long[] v = new long[m];
                for (int j = 0; j < m; j++) {
                    long x = sc.nextLong();
                    v[j] = x - j + 1; 
                }
                Arrays.sort(v);
                a.add(new Pair(v[m - 1], m));
            }
            Collections.sort(a);
            long ans = a.get(0).val;
            int increase = a.get(0).cnt;
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, a.get(i).val - increase);
                increase += a.get(i).cnt;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}

// Time Complexity: O(n log n + k) where k is total number of integers read across all lists
// Space Complexity: O(n + k)
