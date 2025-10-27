// ...existing code...

import java.io.*;
import java.util.*;

public class MahmoudAndEhabAndTheBipartiteness {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            g[u].add(v);
            g[v].add(u);

        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        color[1] = 0;
        long cnt0 = 0, cnt1 = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            if (color[u] == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
            for (int v : g[u]) {
                if (color[v] == -1) {
                    color[v] = color[u] ^ 1;
                    q.add(v);
                }
            }
        }

        long ans = cnt0 * cnt1 - (n - 1);
        System.out.println(ans);
    }

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is;
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
