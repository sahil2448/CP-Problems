
import java.io.*;
import java.util.*;

public class WeirdSum {

    static final int MAX_COLOUR = 100000; // colours are 1..1e5, we'll use 0..99999

    // Computes sum of pairwise absolute differences for values in v
    // Sort descending; coefficient pattern j = n-1, n-3, ..., -(n-1) gives sum_{i<j} (v[i] - v[j])
    static long calculateSumOfAllPairs(ArrayList<Integer> v) {
        Collections.sort(v, Collections.reverseOrder()); // ensure v[i] >= v[j] for i < j
        int n = v.size();
        long sum = 0;
        for (int i = 0, j = n - 1; i < n; i++, j -= 2) {
            sum += (long) j * v.get(i);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] rowsByColour = new ArrayList[MAX_COLOUR]; // rows grouped by color
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] colsByColour = new ArrayList[MAX_COLOUR]; // cols grouped by color
        for (int i = 0; i < MAX_COLOUR; i++) {
            rowsByColour[i] = new ArrayList<>();
            colsByColour[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int c = fs.nextInt() - 1; // 0-based colour for direct indexing
                rowsByColour[c].add(i); // record row index of this colour occurrence
                colsByColour[c].add(j); // record column index of this colour occurrence
            }
        }

        long ans = 0;
        for (int colour = 0; colour < MAX_COLOUR; colour++) {
            // Manhattan distance = |row diff| + |col diff|, sum independently
            ans += calculateSumOfAllPairs(rowsByColour[colour]);
            ans += calculateSumOfAllPairs(colsByColour[colour]);
        }

        System.out.println(ans);

        /*
		Time Complexity (TC): O(nm * log(nm))
		Space Complexity (SC): O(n * m)
         */
    }

    // Fast scanner for competitive programming style input
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
            do {
                c = read();
            } while (c <= ' ');
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
