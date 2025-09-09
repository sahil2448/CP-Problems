
import java.io.*;
import java.util.*;

public class DivisiblePairs {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            int y = fs.nextInt();

            HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int val = fs.nextInt();
                int key = ((val % y) + y) % y;
                mp.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
            }

            long ans = 0;
            for (ArrayList<Integer> v : mp.values()) {
                HashMap<Integer, Long> mp1 = new HashMap<>();
                for (int val : v) {
                    int r = ((val % x) + x) % x;
                    mp1.put(r, mp1.getOrDefault(r, 0L) + 1L);
                }

                HashSet<Integer> processed = new HashSet<>();
                for (Map.Entry<Integer, Long> e : mp1.entrySet()) {
                    int rem = e.getKey();
                    if (processed.contains(rem)) {
                        continue;
                    }
                    long cnt = e.getValue();
                    if (rem == 0 || (x % 2 == 0 && rem == x / 2)) {
                        ans += cnt * (cnt - 1) / 2;
                        processed.add(rem);
                    } else {
                        int other = (x - rem) % x;
                        long cnt2 = mp1.getOrDefault(other, 0L);
                        ans += cnt * cnt2;
                        processed.add(rem);
                        processed.add(other);
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }

    // Fast scanner for competitive programming
    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return Integer.MIN_VALUE;
                }
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
