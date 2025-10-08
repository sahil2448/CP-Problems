
import java.io.*;
import java.util.*;

public class B {

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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            ArrayList<int[]> sets = new ArrayList<>(n);
            int[] cnt = new int[m + 1];

            for (int i = 0; i < n; ++i) {
                int li = fs.nextInt();
                int[] arr = new int[li];
                for (int j = 0; j < li; ++j) {
                    arr[j] = fs.nextInt();
                    cnt[arr[j]]++;
                }
                sets.add(arr);
            }

            boolean allCovered = true;
            for (int x = 1; x <= m; ++x) {
                if (cnt[x] == 0) {
                    allCovered = false;
                    break;
                }
            }
            if (!allCovered) {
                sb.append("NO\n");
                for (int[] s : sets) {
                    for (int v : s) {
                        cnt[v] = 0;
                    }
                }
                continue;
            }

            int removableSets = 0;
            for (int[] s : sets) {
                boolean hasUnique = false;
                for (int v : s) {
                    if (cnt[v] == 1) {
                        hasUnique = true;
                        break;
                    }
                }
                if (!hasUnique) {
                    removableSets++;
                }
            }

            if (removableSets >= 2) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

            for (int[] s : sets) {
                for (int v : s) {
                    cnt[v] = 0;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
