
import java.io.*;
import java.util.*;

public class Loyalty {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String tStr = sc.next();
        if (tStr == null) {
            return;
        }
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = sc.nextInt();
            long X = sc.nextLong();

            long[] a = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sum += a[i];
            }

            // Sort the array to easily pick the k largest items
            Arrays.sort(a);
            int k = (int) (sum / X);

            MultiSet L = new MultiSet();
            MultiSet S = new MultiSet();

            long points = 0;
            // The k largest items go to L
            for (int i = n - 1; i >= n - k; i--) {
                L.add(a[i]);
                points += a[i];
            }
            // The remaining items go to S
            for (int i = n - k - 1; i >= 0; i--) {
                S.add(a[i]);
            }

            out.println(points);

            long cur = 0;
            for (int i = 0; i < n; i++) {
                long T = (cur / X + 1) * X; // The next multiple of X to reach
                long req = T - cur;         // Amount required to cross the threshold

                Long val = L.ceiling(req);

                // If an item in L can cross the threshold, we greedily take the smallest one that works
                if (val != null) {
                    out.print(val + (i == n - 1 ? "" : " "));
                    cur += val;
                    L.remove(val);
                } else {
                    // Otherwise, we inch closer by taking the largest available item from S
                    val = S.max();
                    out.print(val + (i == n - 1 ? "" : " "));
                    cur += val;
                    S.remove(val);
                }
            }
            out.println();
        }
        out.flush();
    }

    // A utility wrapper over TreeMap to act as a MultiSet
    static class MultiSet {

        TreeMap<Long, Integer> map = new TreeMap<>();

        void add(long x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        void remove(long x) {
            int count = map.get(x);
            if (count == 1) {
                map.remove(x);
            } else {
                map.put(x, count - 1);
            }
        }

        Long ceiling(long x) {
            return map.ceilingKey(x);
        }

        Long max() {
            if (map.isEmpty()) {
                return null;
            }
            return map.lastKey();
        }

        boolean isEmpty() {
            return map.isEmpty();
        }
    }

    // Fast I/O scanner to avoid Time Limit Exceeded
    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
